/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sos.gui;

import Dao.PrestataireDAO;
import Entities.Prestataire;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Lenovo
 */
public class TableModelAfficheMétiersAnimaliers extends AbstractTableModel{
     List <Prestataire> listprest =new ArrayList<Prestataire>();

     String [] header={"Nos experts","Adresse Cabinet","Contact","Prix du service","Cochez si vous désiriez en bénéficier"};
     Boolean rowlist[][] = new Boolean[50][50];
    
 //Constructeur
 public TableModelAfficheMétiersAnimaliers(){
 
 }


 //Constructeur
 public TableModelAfficheMétiersAnimaliers(String domaine){


     Prestataire p = new Prestataire();
     PrestataireDAO prestDAO= new PrestataireDAO();

     listprest=prestDAO.getALLPrestataireByDomaine(domaine); //%%%%%%%%%%%%%% jCombobox.selectedItem()

   for (int i = 0; i < getRowCount(); i++) {
        rowlist[i][4]=Boolean.FALSE;  }
 }



   @Override
    public int getRowCount() {
       return listprest.size();
    }

 @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           

         PrestataireDAO prestDAO=new PrestataireDAO();
         Prestataire p = new Prestataire();

         int id_prest= listprest.get(rowIndex).getId();
         String np= listprest.get(rowIndex).getNom()+" "+listprest.get(rowIndex).getPrenom() ;
         String adr = listprest.get(rowIndex).getAdresse();
         int cont = listprest.get(rowIndex).getTelephone();
         Double prix_serv= listprest.get(rowIndex).getPrix_serv();

         p.setId(id_prest);
         p.setNom(listprest.get(rowIndex).getNom());
         p.setPrenom(listprest.get(rowIndex).getPrenom());
         p.setAdresse(adr);
         p.setTelephone(cont);
         p.setPrix_serv(prix_serv);

     switch(columnIndex){
            case 0:return np;
            case 1:return adr;
            case 2:return cont;
            case 3:return prix_serv;
            case 4:return rowlist[rowIndex][4];

            default: return null;
     }

       }
    

 @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      boolean b = (Boolean) aValue;

               if(columnIndex==4) {
                rowlist[rowIndex][4]=b;
                fireTableCellUpdated(rowIndex, columnIndex); }

  }
 @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==4 ){
            return Boolean.class;
        }
        return String.class;
    }
 @Override
    public boolean isCellEditable(int row, int column) {
        return (column >= 4);
     }

    public String getColumnName(int column) {
        return header[column]; //To change body of generated methods, choose Tools | Templates.
    }

  


}
