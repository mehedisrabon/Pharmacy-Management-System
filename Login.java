import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MyClasses.User;
import MySignUp.*;


public class Login implements ActionListener{
    private JFrame frame;
    private JLabel UserNameLabel, UserPassLabel;
    private JButton LogBt, exitBt,singButton;
    private JTextField UnameTF;
    private JPasswordField UpassTF;
    private User ac1, ac2;
    private User users[];

    public Login(){
        ac1 = new User("Mehedi", "2003", "6/12/2003", "0987654321");
        ac2 = new User("Admin", "3002", "24/11/2004", "0123456789");
        users = new User[10];
        users[0] = ac1;
        users[1] = ac2;

        // JFrame
        frame = new JFrame("Login");
        frame.setBounds(400, 200, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane();
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(null);

        // UnameTF
        UnameTF = new JTextField("Mehedi");
        UnameTF.setBounds(200, 70, 150, 20);          
		frame.add(UnameTF);
    
        // UpassTF
        UpassTF = new JPasswordField("6024");
        UpassTF.setBounds(200, 100, 150, 20);
        frame.add(UpassTF);

        // UsernameLabel
        UserNameLabel = new JLabel("Username ");
        UserNameLabel.setBounds(100, 70, 100, 20);
        frame.add(UserNameLabel);

        // PassLabel
        UserPassLabel = new JLabel("Password ");
        UserPassLabel.setBounds(100, 100, 100, 20);
        frame.add(UserPassLabel);

        // LoginButton
        LogBt = new JButton("Login");
        LogBt.setBounds(100, 150, 100, 30);
        LogBt.setBackground(Color.WHITE);
        frame.add(LogBt);

        //Singbutton
        singButton = new JButton("Singup");
        singButton.setBounds(260, 150, 100, 30);
        singButton.setBackground(Color.WHITE);
        frame.add(singButton);
        singButton.addActionListener(this);

        // ExitButton
        exitBt = new JButton("Exit");
        exitBt.setBounds(180, 190, 100, 30);
        exitBt.setBackground(Color.WHITE);
        frame.add(exitBt);
        LogBt.addActionListener(this);
        exitBt.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e){
        String U = UnameTF.getText();
        String P = new String(UpassTF.getPassword());
        int flag = 0;
        if(e.getSource()==LogBt){
            
            for(int i=0; i<users.length; i++){
                if(U.isEmpty() || P.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Boxes can not be empty");
                    break;
                }
                else if (U.equals(users[i].getUserName()) && P.equals(users[i].getUserPass())){
                    flag = 1;
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username or Password incorrect");
                }
            }
            if(flag==1){
                JOptionPane.showMessageDialog(null, "Login Successfull");
                new dashboard();
                frame.setVisible(false);
            }
        }
        else if(e.getSource() == singButton){
            new Myframe();
        }
        else if(e.getSource()==exitBt){
            System.exit(0);
        }
    }
}
