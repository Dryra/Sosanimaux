/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sos;

import java.io.*;
import javax.net.ssl.*;
import java.net.UnknownHostException;

public class EmailService {
    String server = "pop.gmail.com";
    int port = 995;
    String username = "sosanimauxtunisia@gmail.com", password = "sosanimaux.@";

    SSLSocket socket;
    BufferedReader input;
    PrintWriter output;

    public static void main(String[] args) {
        new EmailService();
    }

    public EmailService() {
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket)sslsocketfactory.createSocket(server, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // After each println you MUST flush the buffer, or it won't work properly.
            // The true argument makes an automatic flush after each println.
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            connect();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String connect() throws IOException {
        System.out.print("Greeting message: ");
        String response = readOneLine();
        System.out.println(response);

        // Username
        output.println("USER " + username);
        response = readOneLine();
        System.out.println(response);

        // Password
        output.println("PASS " + password);
        response = readOneLine();
        System.out.println(response);

        output.println("RETR 1");
        while (!response.equals(".")) {
            response = readOneLine();
            System.out.println(response);
        }
        return response ;
    }

    public String readOneLine() throws IOException {
        return input.readLine();
    }
}
