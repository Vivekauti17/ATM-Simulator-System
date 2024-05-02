package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(150, 20, 200, 20);
        add(bank);
        
        JLabel cardno = new JLabel();
        cardno.setBounds(20, 80, 300, 20);
        add(cardno);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        //Need to hit in the database
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from logincredentials where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                cardno.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));    // Integer.parseInt is used to convert string into integer.
                        
                }else {                             // else means type = Withdraw
                    bal -= Integer.parseInt(rs.getString("amount"));
                        
                }
            }
            balance.setText("Your Current Account Balance is Rs " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
// Code by:- Vivek Auti