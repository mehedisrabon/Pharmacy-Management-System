import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JFrame implements ActionListener {
    
    private JTextField searchField;
    private JList<String> itemList;
    private JTextField quantityField;
    private JTextArea cartArea;
    private JLabel totalPriceLabel;
    private DefaultListModel<String> itemModel;
    private JButton addButton,bacButton,payButton,extButton;
    private JButton removeButton;
    
    private double totalPrice;
    
    public UserPanel() {
        setBounds(400, 100, 700, 600);
        setTitle("Sell Medicine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(10, 10, 50, 20);
        add(searchLabel);
        
        searchField = new JTextField();
        searchField.setBounds(60, 10, 200, 20);
        add(searchField);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(270, 10, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);
  
        JLabel itemListLabel = new JLabel("Available Medicines:");
        itemListLabel.setBounds(10, 40, 140, 20);
        add(itemListLabel);
        
        itemModel = new DefaultListModel<>();
        itemModel.addElement("Napa");
        itemModel.addElement("Ativan");
        itemModel.addElement("Napa Extend");
        itemModel.addElement("Caugh syrup");
        itemModel.addElement("Saclo");
        itemList = new JList<>(itemModel);
        JScrollPane itemScrollPane = new JScrollPane(itemList);
        itemScrollPane.setBounds(10, 70, 200, 400);
        add(itemScrollPane);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(220, 70, 60, 20);
        add(quantityLabel);
        
        quantityField = new JTextField();
        quantityField.setBounds(280, 70, 50, 20);
        add(quantityField);
        
        addButton = new JButton("Add to Cart");
        addButton.setBounds(220, 100, 110, 20);
        addButton.setBackground(Color.WHITE);
        addButton.addActionListener(this);
        add(addButton);
        
        removeButton = new JButton("Remove from Cart");
        removeButton.setBounds(220, 130, 150, 20);
        removeButton.setBackground(Color.WHITE);
        removeButton.addActionListener(this);
        add(removeButton);
 
        bacButton = new JButton("Back");
        bacButton.setBounds(10, 510, 100, 20);
        bacButton.setBackground(Color.WHITE);
        bacButton.addActionListener(this);
        add(bacButton); 
        
        payButton = new JButton("Payment Done");
        payButton.setBounds(500, 510, 140, 20);
        payButton.setBackground(Color.WHITE);
        payButton.addActionListener(this);
        add(payButton); 

        extButton = new JButton("Exit");
        extButton.setBounds(570, 10, 80, 20);
        extButton.setBackground(Color.WHITE);
        extButton.addActionListener(this);
        add(extButton); 
        
        cartArea = new JTextArea();
        JScrollPane cartScrollPane = new JScrollPane(cartArea);
        cartScrollPane.setBounds(380, 70, 300, 400);
        add(cartScrollPane);
 
        JLabel totalPriceTextLabel = new JLabel("Total Price:");
        totalPriceTextLabel.setBounds(220, 480, 80, 20);
        add(totalPriceTextLabel);
        
        totalPriceLabel = new JLabel("0.00 tk");
        totalPriceLabel.setBounds(300, 480, 100, 20);
        add(totalPriceLabel);
        
        setVisible(true);
    }
    @Override
	//eta chatgpt er help niye korsi
public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof JButton) {
        JButton sourceButton = (JButton) e.getSource();
        if (sourceButton == addButton) {
            int selectedIndex = itemList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedItem = itemModel.getElementAt(selectedIndex);
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    double itemPrice = calculatePrice(selectedItem, quantity);
                    totalPrice += itemPrice;
                    cartArea.append(selectedItem + " x" + quantity + " - tk" + String.format("1.00", itemPrice) + "\n");
                    totalPriceLabel.setText("tk" + String.format("1.00", totalPrice));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item from the list.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else if(e.getSource() == bacButton){
            setVisible(false);
        }
        else if(e.getSource() == payButton){
            JOptionPane.showMessageDialog(this, "Confirm Payment???", "Payment Done", JOptionPane.YES_NO_CANCEL_OPTION) ;
            setVisible(false); 
        }
        else if(e.getSource() == extButton){
            System.exit(0);
        }
        else if (sourceButton == removeButton) {
            cartArea.setText("");
            totalPrice = 0.0;
            totalPriceLabel.setText("0.00 tk");
        }
    } else if (e.getSource() instanceof JTextField) {
        JTextField sourceField = (JTextField) e.getSource();
        if (sourceField == searchField) {
            String searchQuery = searchField.getText().toLowerCase();
            if (searchQuery.trim().isEmpty()) {
                itemModel.removeAllElements();
                itemModel.addElement("Napa");
                itemModel.addElement("Ativan");
                itemModel.addElement("Napa Extend");
                itemModel.addElement("Caugh syrup");
                itemModel.addElement("Saclo");
            } else {
                itemModel.removeAllElements();
                for (int i = 1; i <= 5; i++) {
                    String item = "Item " + i;
                    if (item.toLowerCase().contains(searchQuery)) {
                        itemModel.addElement(item);
                    }
                }
            }
        }
    }
}
//etotuk!
private double calculatePrice(String itemName, int quantity) {
    double price = 0.0;
    if (itemName.equals("Napa")) {
        price = 1.0;
    } else if (itemName.equals("Ativan")) {
        price = 1.5;
    } else if (itemName.equals("Napa Extend")) {
        price = 2.0;
    } else if (itemName.equals("Caugh syrup")) {
        price = 2.5;
    } else if (itemName.equals("Saclo")) {
        price = 3.0;
    }
    return price * quantity;
}

}