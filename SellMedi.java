import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MyClasses.Medicine;

public class SellMedi extends MedicineOperationADD {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    public SellMedi() {
        frame = new JFrame("Medicine List");
        frame.setBounds(100, 100, 900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Date");
        model.addColumn("Quantity");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(360, 50, 500, 250);
        frame.add(scrollPane);

        for (int i = 0; i < 101; i++) {
            if (MediArry[i] != null) {
                model.addRow(new Object[]{MediArry[i].getName(), MediArry[i].getPrice(), MediArry[i].getDate(), MediArry[i].getQuantity()});
            }
        }
    }
    }
