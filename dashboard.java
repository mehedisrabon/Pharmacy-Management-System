import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.*;

public class dashboard implements ActionListener {
    private JFrame frame;
    private JTextField srcTxF;
    private JButton addM, sellM, src, prf, Lgout,exButton;
    private JTable table;
    private DefaultTableModel model;

    public dashboard() {
        frame = new JFrame("Dashboard");
        frame.setBounds(400, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setVisible(true);
        frame.getContentPane();
        frame.setLayout(null);

        // add TextField
        srcTxF = new JTextField();
        srcTxF.setBounds(70, 50, 270, 30); // set bounds for TextField
        frame.add(srcTxF);

        // addButton
        addM = new JButton("Add Medicine");
        addM.setBounds(70, 120, 130, 100); // resized width to 130 pixels, centered horizontally
        addM.setBackground(Color.WHITE);
        frame.add(addM);
        addM.addActionListener(this);

        // sellButton
        sellM = new JButton("Sell Medicine");
        sellM.setBounds(280, 120, 130, 100); // resized width to 130 pixels, centered horizontally below "Add Medicine" button
        sellM.setBackground(Color.WHITE);
        frame.add(sellM);
        sellM.addActionListener(this);

        // srcButton
        src = new JButton("Search");
        src.setBounds(350, 50, 100, 30); // set bounds for Search button
        src.setBackground(Color.WHITE);
        frame.add(src);
        src.addActionListener(this);

        // prfButton
        prf = new JButton("Profile");
        prf.setBounds(20, 10, 80, 30); // set bounds for Profile button
        prf.setBackground(Color.WHITE);
        frame.add(prf);

        // logButton
        Lgout = new JButton("Logout");
        Lgout.setBounds(120, 10, 80, 30); // set bounds for Profile button
        Lgout.setBackground(Color.WHITE);
        frame.add(Lgout);
        Lgout.addActionListener(this);

        exButton = new JButton("Exit");
        exButton.setBounds(200, 240, 80, 30); // set bounds for Profile button
        exButton.setBackground(Color.WHITE);
        frame.add(exButton);
        exButton.addActionListener(this);        

        /*
        // Creating the table model
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Date");
        model.addColumn("Quantity");

        // Creating the table
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 230, 380, 100);
        frame.add(scrollPane);
        */
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addM) {
            new AddMedi();
        }
        else if (e.getSource() == sellM){
            new UserPanel();
        }
        /* 
          else if (e.getSource() == src) {
            String name = srcTxF.getText();

            // Clear the table model
            model.setRowCount(0);

            // Search for matching medicine names and add them to the table model
            for (Medicine medicine : Medicine.medicine) {
                if (medicine != null && medicine.getName().equalsIgnoreCase(name)) {
                    model.addRow(new Object[]{medicine.getName(), medicine.getPrice(), medicine.getDate(), medicine.getQuantity()});
                }
            }
        }
        */
        
        else if(e.getSource()==Lgout){
            frame.setVisible(false);
            new Login();
        }
        else if (e.getSource()==exButton){
            System.exit(0);
        }
    }
}
