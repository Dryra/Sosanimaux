package sos;

import Dao.DaoInt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



@SuppressWarnings("deprecation")
public class RecupererInfoFacebook {



    static int id_adh = 0 ;
    private final FacebookClient facebookClient;
 
    public static void main(String[] args) throws SQLException, IOException {
        new RecupererInfoFacebook("CAADiEqZCqAucBANcHZCHIYQLDNS0nE1JQnGwucSV5eTJl5JsfgxXnBTrsmn19np5dbvj2O3bgZC70Aldtjjbh5BqZASkFsqQlnqWqdfsIQZBn2Rs2PYwRu5JtyZCRj0rAK9bB3uyukIBMmhfQycmB0Aj84etJFnLNvsDrH3aZCo4G21UyjajNa1").GetFacebookId();
    }

    RecupererInfoFacebook(String accessToken) {
        facebookClient = new DefaultFacebookClient(accessToken);
    }

//    void runEverything() {
//        GetFacebookId();
//        fetchObjectsAsJsonObject();
//        fetchObjects();
//        fetchConnections();
//        fetchDifferentDataTypesAsJsonObject();
//        query();
//        multiquery();
//        search();
//        metadata();
//        paging();
//        selection();
//        parameters();
//        rawJsonResponse();
//    }
    
    
    public String GetFacebookId() throws SQLException, IOException  {

        DaoInt da = new DaoInt();
String rep="";

        User user = facebookClient.fetchObject("me", User.class);

        System.out.println(user.getEmail());
System.out.println(user.getHometown());
        if (da.checkmail(user.getEmail()).equals("yes")) {
            System.out.println("good id fb exist");
            System.out.println("ville="+user.getHometownName());
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Vous étes deja inscri !");
            
            return user.getEmail();


        } else {
    //URL url = getClass().getResource("http://profile.ak.fbcdn.net/hprofile-ak-ash1/t5/274428_1101376234_491465847_n.jpg");
  //Image img = ImageIO.read(url);
File imgfile = new File("C:\\Users\\Dryra\\Desktop\\fbpicture.jpg");
            List<String> informations = new ArrayList<String>();
            informations.add(user.getId());
            informations.add(user.getLastName());
            informations.add(user.getFirstName());
            informations.add(user.getEmail());
            informations.add(user.getHometownName());
            informations.add(user.getGender());
            System.out.println("ville="+user.getHometownName());
            //JFrame jf = new JFrame();
//            JLabel pn = new JLabel();
//        JPanel panel = new JPanel();
//            Image image ;
//
//    img.getScaledInstance(pn.getWidth(), pn.getHeight(), img.SCALE_FAST);
// ImageIcon icon = new ImageIcon(img);
//
//            pn.setIcon(icon);
//
//jf.add(pn);




           da.insertadherantbyfacebook(informations,imgfile);
            System.out.println("Ajout dans la base");
            SOSEspaceAdherant espace_adherant = new SOSEspaceAdherant(Integer.parseInt(user.getId()));
            espace_adherant.setVisible(true);
 id_adh=Integer.parseInt(user.getId());

            return user.getEmail();


            
        }
    }

    


    

//        System.out.println("Name: " + user.getName());
//        System.out.println("Relation: " + user.getRelationshipStatus());
//        out.println("Username: " + user.getUsername());
//        out.println("Email: " + user.getEmail());
//        out.println("ID Facebook: " + user.getId());
//        out.println("About: " + user.getAbout());
//        out.println("Birthday: " + user.getBirthday());
//        System.out.println("Favourite Teams: " + user.getFavoriteTeams().toString());
//
//        System.out.println("Page link: " + page.getLink());
//        System.out.println("Mission of the page: " + page.getMission());
//        out.println("Page likes: " + page.getLikes());
//
//    void fetchObjectsAsJsonObject() {
//        out.println("* Fetching multiple objects at once as a JsonObject *");
//
//        List<String> ids = new ArrayList<String>();
//        ids.add("me");
//        ids.add("https://www.facebook.com/fcbarcelona");
//
//         Make the API call
//        JsonObject results = facebookClient.fetchObjects(ids, JsonObject.class);
//
//         Pull out JSON data by key and map each type by hand.
//        JsonMapper jsonMapper = new DefaultJsonMapper();
//        User user = jsonMapper.toJavaObject(results.getString("me"), User.class);
//        Url url = jsonMapper.toJavaObject(results.getString("https://www.facebook.com/fcbarcelona"), Url.class);
//
//        out.println("User is " + user);
//        out.println("URL is " + url);
//    }
//
//    void fetchObjects() {
//        out.println("* Fetching multiple objects at once *");
//
//        FetchObjectsResults fetchObjectsResults
//                = facebookClient.fetchObjects(Arrays.asList("me", "FCBarcelona"), FetchObjectsResults.class);
//
//        out.println("User name: " + fetchObjectsResults.me.getName());
//        System.out.println("Page name: " + fetchObjectsResults.page.getName());
//        out.println("Page likes: " + fetchObjectsResults.page.getLikes());
//    }
//
//    void fetchDifferentDataTypesAsJsonObject() {
//        out.println("* Fetching different types of data as JsonObject *");
//
//        JsonObject me = facebookClient.fetchObject("me", JsonObject.class);
//        out.println(me.getString("name"));
//
//        JsonObject photosConnection = facebookClient.fetchObject("me/photos", JsonObject.class);
//        JsonArray photosConnectionData = photosConnection.getJsonArray("data");
//
//        if (photosConnectionData.length() > 0) {
//            String firstPhotoUrl = photosConnectionData.getJsonObject(0).getString("source");
//            out.println(firstPhotoUrl);
//        }
//
//        https://developers.facebook.com/docs/reference/fql/
//        String query = "SELECT first_name, last_name, about_me, profile_url FROM user WHERE uid = 1116395571";
//        List<JsonObject> queryResults = facebookClient.executeQuery(query, JsonObject.class);
//
//        if (queryResults.size() > 0) {
//            System.out.println(queryResults.get(0).getString("first_name"));
//            System.out.println(queryResults.get(0).getString("last_name"));
//            System.out.println(queryResults.get(0).getString("about_me"));
//            System.out.println(queryResults.get(0).getString("profile_url"));
//        }
//    }
//
//    public static class FetchObjectsResults {
//
//        @Facebook
//        User me;
//        @Facebook(value = "cocacola")
//        Page page;
//    }
//
//    void fetchConnections() {
//        out.println("* Fetching connections *");
//
//        Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
//        Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);
//
//        out.println("Count of my friends: " + myFriends.getData().size());
//
//        if (myFeed.getData().size() > 0) {
//            out.println("First item in my feed: " + myFeed.getData().get(0).getMessage());
//        }
//    }
//
//    void query() {
//        out.println("* FQL Query *");
//
//        List<FqlUser> users
//                = facebookClient.executeQuery("SELECT uid, name FROM user WHERE uid=220439 or uid=7901103", FqlUser.class);
//
//        out.println("User: " + users);
//    }
//
//    void multiquery() {
//        out.println("* FQL Multiquery *");
//
//        Map<String, String> queries = new HashMap<String, String>();
//        queries.put("users", "SELECT uid, name FROM user WHERE uid=220439 OR uid=7901103");
//        queries.put("likers", "SELECT user_id FROM like WHERE object_id=122788341354");
//
//        MultiqueryResults multiqueryResults = facebookClient.executeMultiquery(queries, MultiqueryResults.class);
//
//        out.println("Users: " + multiqueryResults.users);
//        out.println("People who liked: " + multiqueryResults.likers);
//    }
//
//    public static class FqlUser {
//
//        @Facebook
//        String uid;
//        @Facebook
//        String name;
//
//        @Override
//        public String toString() {
//            return format("%s (%s)", name, uid);
//        }
//    }
//
//    public static class FqlLiker {
//
//        @Facebook("user_id")
//        String userId;
//
//        @Override
//        public String toString() {
//            return userId;
//        }
//    }
//
//    /**
//     * Holds results from a "multiquery" call.
//     */
//    public static class MultiqueryResults {
//
//        @Facebook
//        List<FqlUser> users;
//        @Facebook
//        List<FqlLiker> likers;
//    }
//
//    void search() {
//        out.println("* Searching connections *");
//
//        Connection<Post> publicSearch
//                = facebookClient.fetchConnection("search", Post.class, Parameter.with("q", "ben foulen"),
//                        Parameter.with("type", "post"));
//
//        Connection<User> targetedSearch
//                = facebookClient.fetchConnection("me/home", User.class, Parameter.with("q", "foulen"),
//                        Parameter.with("type", "user"));
//
//        if (publicSearch.getData().size() > 0) {
//            out.println("Public search: " + publicSearch.getData().get(0).getMessage());
//        }
//
//        out.println("Posts on my wall by friends named Mark: " + targetedSearch.getData().size());
//    }
//
//    void metadata() {
//        out.println("* Metadata *");
//
//        User userWithMetadata = facebookClient.fetchObject("me", User.class, Parameter.with("metadata", 1));
//
//        out.println("User metadata: has albums? " + userWithMetadata.getMetadata().getConnections().hasAlbums());
//    }
//
//    void paging() {
//        out.println("* Paging support *");
//
//        Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
//        Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 100));
//
//        out.println("Count of my friends: " + myFriends.getData().size());
//
//        if (myFeed.getData().size() > 0) {
//            out.println("First item in my feed: " + myFeed.getData().get(0));
//        }
//
//        for (List<Post> myFeedConnectionPage : myFeed) {
//            for (Post post : myFeedConnectionPage) {
//                out.println("Post from my feed: " + post);
//            }
//        }
//    }
//
//    void selection() {
//        out.println("* Selecting specific fields *");
//
//        User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "id,name"));
//
//        out.println("User name: " + user.getName());
//    }
//
//    void parameters() {
//        out.println("* Parameter support *");
//
//        Date oneWeekAgo = new Date(currentTimeMillis() - 1000L * 60L * 60L * 24L * 7L);
//
//        Connection<Post> filteredFeed
//                = facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 3),
//                        Parameter.with("until", "yesterday"), Parameter.with("since", oneWeekAgo));
//
//        out.println("Filtered feed count: " + filteredFeed.getData().size());
//    }
//
//    void rawJsonResponse() {
//        out.println("* Raw JSON *");
//        out.println("User object JSON: " + facebookClient.fetchObject("me", String.class));
//    }
//    private void authentifierCovoitureurFacebook(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}