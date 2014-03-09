/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sos;

import Dao.Daopension;
import Dao.PrestataireDAO;
import Entities.Pension;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Lenovo
 */
public class TableModelAfficheEditAllPensions extends AbstractTableModel{
     List <Pension> listpens =new ArrayList<Pension>();
     PrestataireDAO pDAO = new PrestataireDAO();

 String [] header={"Nom Pension","Adresse Pension","N°Téléphone Pension","Prix Pension","Nom Pensionnaire","Cocher Pour supprimer"};
   Boolean rowlist[][] = new Boolean[50][50];
    private Daopension pensionDAO;

 //Constructeur
 public TableModelAfficheEditAllPensions(){

      pensionDAO=new Daopension();
     listpens= pensionDAO.AfficherAllPension();
     System.out.println(""+listpens.size());
     for (int i = 0; i < listpens.size(); i++) {
        rowlist[i][5]=Boolean.FALSE;  }
 }

 
   @Override
    public int getRowCount() {
       return listpens.size();
    }

 @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

     switch(columnIndex){
            case 0:return listpens.get(rowIndex).getNom();
            case 1:return listpens.get(rowIndex).getAdresse();
            case 2:return listpens.get(rowIndex).getTelephone();
            case 3:return listpens.get(rowIndex).getPrix_pens();
            case 4:
                    int nb= listpens.get(rowIndex).getId_prest();
                    String ch= pDAO.getNamePrestataireByID(nb);
                    return ch ;
            case 5:return rowlist[rowIndex][5];

         default:return null;

    }


}

 @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     //pour la mise à jour des cases du tableau lors de la modification
     if(columnIndex==5)
     { boolean b = (Boolean) aValue;
     
            rowlist[rowIndex][5]=b;
                fireTableCellUpdated(rowIndex, columnIndex); 
     }

  if(columnIndex<5)     {

            
           
            String b ;

            Daopension pdao = new Daopension();
            PrestataireDAO  prestDAO = new PrestataireDAO() ;
            Pension p = new Pension();
   switch (columnIndex){

    case 0: // nom

        p.setAdresse((String)this.getValueAt(rowIndex, 1));
        p.setTelephone(((Integer)this.getValueAt(rowIndex, 2)));
  p.setPrix_pens(((Double)this.getValueAt(rowIndex,3)));
        int id= prestDAO.getIDPrestataireByName(this.getValueAt(rowIndex, 4).toString());
        p.setId_prest(id);
             b = (String) aValue;
        p.setNom(b);
        pdao.updatePension(p);
        break;

     case 1: //adr
           p.setNom((String)this.getValueAt(rowIndex, 0));
           p.setTelephone(((Integer)this.getValueAt(rowIndex, 2)));
           p.setPrix_pens(((Double)this.getValueAt(rowIndex,3)));
           int id1= prestDAO.getIDPrestataireByName(this.getValueAt(rowIndex, 4).toString());
           p.setId_prest(id1);
             b = (String) aValue;

           p.setAdresse(b);
           pdao.updatePension(p);
        break;

        case 2: //Tel
             p.setNom((String)this.getValueAt(rowIndex, 0));
             p.setAdresse((String)this.getValueAt(rowIndex, 1));
             p.setPrix_pens(((Double)this.getValueAt(rowIndex,3)));

            int id2= prestDAO.getIDPrestataireByName(this.getValueAt(rowIndex, 4).toString());
            p.setId_prest(id2);
            int a = (Integer) Integer.valueOf((String)aValue) ;
            p.setTelephone(a);
            pdao.updatePension(p);
        break;

        case 3: //prix
             p.setNom((String)this.getValueAt(rowIndex, 0));
             p.setAdresse((String)this.getValueAt(rowIndex, 1));
             p.setTelephone(((Integer)this.getValueAt(rowIndex, 2)));
             p.setPrix_pens(((Double)this.getValueAt(rowIndex,3)));

             int id3= prestDAO.getIDPrestataireByName(this.getValueAt(rowIndex, 4).toString());
             p.setId_prest(id3);
             Double c = Double.valueOf((String)aValue) ;
             p.setPrix_pens(c);
             pdao.updatePension(p);
        break;

        case 4: // nom prest (id)

            p.setNom((String)this.getValueAt(rowIndex, 0));
            p.setAdresse((String)this.getValueAt(rowIndex, 1));
            p.setTelephone(((Integer)this.getValueAt(rowIndex, 2)));
            p.setPrix_pens(((Double)this.getValueAt(rowIndex,3)));
            b = (String) aValue;

           int id4 = prestDAO.getIDPrestataireByName(b);
           p.setId_prest(id4);
           pdao.updatePension(p);
            break;

}

                fireTableCellUpdated(rowIndex, columnIndex);

     }
     
  }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if(columnIndex==5)
        {
            return Boolean.class;
        }
       
       return String.class;
    }




 @Override
    public boolean isCellEditable(int row, int column) {
        return (column >= 0);
     }

    public String getColumnName(int column) {
        return header[column]; //To change body of generated methods, choose Tools | Templates.
    }


}
