package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin, repin;       // Password should be hidden whilw typing.
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 290, 500, 35);
        image.add(text);
        
        
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165, 330, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();          // Password should be hidden whilw typing.
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(330, 330, 180, 25);
        image.add(pin);
        
        
        JLabel repintext = new JLabel("RE-ENTER NEW PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165, 370, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField();        // Password should be hidden whilw typing.
        repin.setFont(new Font("Raleway", Font.BOLD, 20));
        repin.setBounds(330, 370, 180, 25);
        image.add(repin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }
            
            // Now, need to connect with database after getting data from user.
            Conn conn = new Conn();
            // 3 Databases have the pin column, so we need to update pin in all three databases(i.e in logincredentials, bank, signup3)
            // So, need to write 3 Query's
            String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            String query2 = "update logincredentials set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            String query3 = "update signup3 set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
    
}
// Code by:- Vivek Auti