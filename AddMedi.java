import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyClasses.*;

public class AddMedi implements ActionListener {
    private JFrame frame;
    private JTextField nameField, priceField, dateField, quantityField;
    private JButton addM, resetB, doneB;
    private JTable table;
    private DefaultTableModel model;
    private MedicineOperationADD addmedi = new MedicineOperationADD("d");
    
	//public Medicine MediArry[];

    public AddMedi() {
        frame = new JFrame("Add Medicine");
        frame.setBounds(100, 100, 900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setVisible(true);
        frame.getContentPane();
        frame.setLayout(null);


        
		//MediArry = new Medicine [51];
		


        // Creating and setting bounds for Name label
        JLabel nameL = new JLabel("Name:");
        nameL.setBounds(50, 50, 80, 25);
        frame.add(nameL);

        // Creating and setting bounds for Name text field
        nameField = new JTextField();
        nameField.setBounds(140, 50, 200, 25);
        frame.add(nameField);

        // Creating and setting bounds for Price label
        JLabel priceL = new JLabel("Price:");
        priceL.setBounds(50, 100, 80, 25);
        frame.add(priceL);

        // Creating and setting bounds for Price text field
        priceField = new JTextField();
        priceField.setBounds(140, 100, 200, 25);
        frame.add(priceField);

        // Creating and setting bounds for Date label
        JLabel dateL = new JLabel("Date:");
        dateL.setBounds(50, 150, 80, 25);
        frame.add(dateL);

        // Creating and setting bounds for Date text field
        dateField = new JTextField();
        dateField.setBounds(140, 150, 200, 25);
        frame.add(dateField);

        // Creating and setting bounds for Quantity label
        JLabel quantityL = new JLabel("Quantity:");
        quantityL.setBounds(50, 200, 80, 25);
        frame.add(quantityL);

        // Creating and setting bounds for Quantity text field
        quantityField = new JTextField();
        quantityField.setBounds(140, 200, 200, 25);
        frame.add(quantityField);

        // Creating and setting bounds for Add Medicine button
        addM = new JButton("Add Medicine");
        addM.setBounds(50, 250, 120, 25);
        addM.setBackground(Color.WHITE);
        frame.add(addM);

        // Creating and setting bounds for Reset button
        resetB = new JButton("Reset");
        resetB.setBounds(190, 250, 80, 25);
        resetB.setBackground(Color.WHITE);
        frame.add(resetB);

        // Creating and setting bounds for Done button
        doneB = new JButton("Done");
        doneB.setBounds(100, 300, 120, 25);
        doneB.setBackground(Color.WHITE);
        frame.add(doneB);

        // Creating the table model
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Date");
        model.addColumn("Quantity");

        // Creating the table
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(360, 50, 500, 250);
        frame.add(scrollPane);

        // adding ActionListener
        addM.addActionListener(this);
        resetB.addActionListener(this);
        doneB.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String price = priceField.getText();
        String date = dateField.getText();
        String quantity = quantityField.getText();

        if(e.getSource()==addM){

            Medicine med = new Medicine();

            med.setName(name);
            med.setPrice(Double.parseDouble(price));
            med.setDate(date);
            med.setQuantity(Integer.parseInt(quantity));

            addmedi.addMedicine(med);
        /*    boolean added = false;
            for(int i=0; i<50;i++){
                if(MediArry[i] == null){
                MediArry[i] = new Medicine();
                MediArry[i].setName(name);
                MediArry[i].setPrice(Double.parseDouble(price));
                MediArry[i].setDate(date);
                MediArry[i].setQuantity(Integer.parseInt(quantity));
                */
                model.addRow(new Object[]{med.getName(), med.getPrice(), med.getDate(), med.getQuantity()});
                
                nameField.setText("");
                priceField.setText("");
                dateField.setText("");
                quantityField.setText("");

/* 
                added = true;
                break;
                }   
            }
            if(!added){
                JOptionPane.showMessageDialog(null, "No more Space to add");
            }*/
        }
        
            else if (e.getSource() == resetB) {
                // Reset the text fields
                nameField.setText("");
                priceField.setText("");
                dateField.setText("");
                quantityField.setText("");
            } else if (e.getSource() == doneB) {
                frame.setVisible(false);
            }
            }

}

