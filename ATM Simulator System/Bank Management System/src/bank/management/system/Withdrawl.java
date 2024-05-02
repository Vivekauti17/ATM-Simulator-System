package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amountTextField;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(190, 300, 400, 20);
        image.add(text);                            // This line is used for Adding text on the image, not only on the frame.
        
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(190, 350, 290, 25);
        image.add(amountTextField);
        
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String amtnumber = amountTextField.getText();
            Date date = new Date();        // Date is a class of util library.
            if (amtnumber.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amtnumber+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amtnumber+" Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
     public static void main(String args[]){
        new Withdrawl("");
    }
    
}
// Code by:- Vivek Auti