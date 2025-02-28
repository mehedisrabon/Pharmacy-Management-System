


import javax.swing.*;
import javax.swing.table.*;

import MyClasses.Medicine;

public class MedicineOperationADD extends Medicine {
    public Medicine MediArry[];
    public JFrame frame;
    public JTable table;
    public DefaultTableModel model;
    public MedicineOperationADD(){

    }

    public MedicineOperationADD(String m){
        MediArry = new Medicine [51];
    }
    public void addMedicine(Medicine m){
        boolean added = false;
            for(int i=0; i<50;i++){
                if(MediArry[i] == null){
                MediArry[i]= m;
                added = true;
                break;
                }   
            }
            if(!added){
                JOptionPane.showMessageDialog(null, "No more Space to add");
            }
    }
    
    /*public void showMedicine(){
        frame = new JFrame("Add Medicine");
        frame.setBounds(100, 100, 900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane();
        frame.setLayout(null);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Date");
        model.addColumn("Quantity");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(360, 50, 500, 250);
        frame.add(scrollPane);
        for(int i=0; i<51;i++){
            if(MediArry[i] != null){
                model.addRow(new Object[]{MediArry[i].getName(),MediArry[i].getPrice(), MediArry[i].getDate(), MediArry[i].getQuantity()});
            }
        }
    } */
    
    
}
