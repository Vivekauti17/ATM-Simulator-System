package bank.management.system;

// javax x is because swing package is came from extended package of java  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;        //awt.event package includes interface ActionListener , therefore this package is used
import java.sql.*;    // We are using this, because ResultSet is a class of java.sql library.

// JFrame is a class of Swing which is extended by JFrame(Inheritance concept)
public class Login extends JFrame implements ActionListener {
// Interface ActionListener is implemented to performs some actions on the Buttons
    
    JButton login, clear, signup;       // These Buttons are declared Globally, now it has scope outside the Constructor also.
    JTextField cardTextField;           // Declared Globally.
    JPasswordField pinTextField;        // Declared Globally.
    
    
    Login() {                           // All code we need to write in constructor only, because immediate after calling object of class Login, Frame should Open
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);               // In this Frame, we have "Border layout" by default. in which labelimage is center aligned ,therfore it displays in middle of the frame.
        // We dont want use any Layout of swing, we want to custom our layout, so, we need to null Layout i.e setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg")); // i1 object of ImageIcon class is created
                                                                                      // ClassLoader is a class & getSystemResource is method
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    // To scale dimesion of image, Image class created by importing java.awt.*; Library
                                                                                      // We cannot put Image (ie. i2) in JLabel, First we need to convert Image into ImageIcon
        ImageIcon i3 = new ImageIcon(i2);                                                                              
        JLabel labelimage = new JLabel(i3);              // JLabel is a class of java Swing . JLabel is used to display a short string or an image icon.
        add(labelimage);
        labelimage.setBounds(70, 10, 100, 100);          // setBounds is a function to change the location of label
        
        
        JLabel text = new JLabel("Welcome to ATM");      // text object is created from JLabel class of swing. JLabel is majorly used whenever we want to write anything on the frame
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        
        JLabel cardno = new JLabel("Card No:");               // cardno object is created to display Text "Card No:"
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        //JTextField cardTextField = new JTextField();   // This was declared Locally.
        cardTextField = new JTextField();         // cardTextField object is created from JTextField class of swing to create TextField
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        
        JLabel pin = new JLabel("PIN:");                     // pin object is created to display Text "PIN:"
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        //JPasswordField pinTextField = new JPasswordField();     // This was declared Locally.
        pinTextField = new JPasswordField();          // pinTextField object is created from JPasswordField class of swing to create TextField.
        pinTextField.setBounds(300, 220, 230, 30);                // JPasswordField is a class where password is hided with *
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        
        //JButton login = new JButton("SIGN IN");  // This was declared Locally , but has scope inside this Constructor only. 
        login = new JButton("SIGN IN");      // "SIGN IN" Button created
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);                           // It is a function to catch a event of Button. It will tell that Click has done on this button.
        add(login);
        
        //JButton clear = new JButton("CLEAR");  // This was declared Locally , but has scope inside this Constructor only.
        clear = new JButton("CLEAR");       // "CLEAR" Button created
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);                           // It is a function to catch a event of Button. It will tell that Click has done on this button.
        add(clear);
        
        //JButton signup = new JButton("SIGN UP");  // This was declared Locally , but has scope inside this Constructor only.
        signup = new JButton("SIGN UP");       // "SIGN UP" Button created
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);                           // It is a function to catch a event of Button. It will tell that Click has done on this button.
        add(signup);
        
        getContentPane().setBackground(Color.WHITE); // This function is used to change background color of the frame.
        
        setSize(800, 480); // Function to set Dimensions of Frame
        setVisible(true);  // Function to make Frame visible, otherwise it'll be Hidden
        setLocation(350, 200); // Function to Display Frame in Middle of the Screen(as per dimension)
        
    }
    
    // If we have any interface(for eg. ActionListener) in java and we implements that interface, then all the methods in that interface we need to override. 
    // In ActionListener interface there is one method which is declared not defined, so it is abstract method,and we need to override it.
    public void actionPerformed(ActionEvent ae){           // After clicking the Button, this function tells what action need to Perform.
        if(ae.getSource() == clear ){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == login ){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            //Now, this query is used to retreive the data from tables.
            String query = "Select * from logincredentials where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
                                                              //database       String             database       String
            try{
                // ResultSet is a class of java.sql library used to basically return the result set. Type of Data is ResultSet.
                ResultSet rs = conn.s.executeQuery(query);    //Here, we are using executeQuery instead of executeUpdate because this query is of DDL Command.
                if (rs.next()){        //It means data is carried successfully, login has done successfully.
                    setVisible(false); // Now, to close login Page.
                    new Transactions(pinnumber).setVisible(true);    //Then, Open Transactions frame.
                    
                } else {              // If credentials doesn't match.
                    JOptionPane.showMessageDialog(null, "Invalid Card No. or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
                                                              
        } else if(ae.getSource() == signup ){
            setVisible(false);
            new SignUpOne().setVisible(true);    // By making SignUpOne object, now we are able to go to SignUpOne page by clicking SignUp Button.
        }
    }

    public static void main(String args[]) {
        new Login();    // Just after making Object , constructor called. That's why we need to make Login constructor
        
    }

}
// Code by:- Vivek Auti