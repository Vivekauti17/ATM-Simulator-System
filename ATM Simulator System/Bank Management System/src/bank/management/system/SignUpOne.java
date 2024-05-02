package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;                         // java.util library includes Random class.
import com.toedter.calendar.JDateChooser;   // This library allows JDateChooser class to choose date from calendar which is imported from jcalender jar file.
import java.awt.event.*;


public class SignUpOne extends JFrame implements ActionListener {
    
    long random;              // All these are declared Globally.
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    
    
    SignUpOne() {
        
        setLayout(null);
        
        Random ran = new Random();    // Random is a class used to generate Random No. (Here , we created instance of Random class)
        //long random = Math.abs((ran.nextLong() % 9000L) + 1000L);    // % 9000L, + 1000L is used reduce the length of result no. i.e to 4 Digit. (Math.abs is a method used to convert -ve int into +ve Integer)
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. :" + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        //JTextField nameTextField = new JTextField();
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        //JTextField fnameTextField = new JTextField();
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        //JDateChooser dateChooser = new JDateChooser();
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        //JRadioButton male = new JRadioButton("Male");
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        //JRadioButton female = new JRadioButton("Female");
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();    // ButtonGroup allows user to choose either male or female, can't choose both.
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        //JTextField emailTextField = new JTextField();
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        //JRadioButton married = new JRadioButton("Married");
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        //JRadioButton unmarried = new JRadioButton("Unmarried");
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        //JRadioButton other = new JRadioButton("Other");
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();    // ButtonGroup allows user to choose either married either unmarried or other, can't choose all.
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        //JTextField addressTextField = new JTextField();
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        //JTextField cityTextField = new JTextField();
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        //JTextField stateTextField = new JTextField();
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        //JTextField pinTextField = new JTextField();
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        
        //JButton next = new JButton("Next");
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
                     // Now, all the values are needed to be store in database.
        // Random no. are converted into string to store in database.
        String formno = "" + random;
        // getText Method is used to extract the value from TextField.
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if (unmarried.isSelected()){
            marital = "Unmarried";
        }else if (other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        //Now, we need to hit in the database.
        //Database is external entity so, need to perform exception handling.Because Error occurring chances are there at Runtime.
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");        // Used for pop-up message.
            } else {
                //Call the database. For that, first we need to establish a connection with mysql
                //After Connection, we are able to run the query of mysql
                Conn c = new Conn();     //c object is made of Conn class.
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";            // Here, we tring to insert the data into mysql. By using DML, insert Command.
                                                      //  "String'"+variable+"'String"
                //4. Execute Query
                // Statement s which was created in Conn class is used to Execute Query.
                c.s.executeUpdate(query);   // This is a DML Command, executeUpdate function is used by passing Query in it.
                // So, By this, our query will run in mysql.
                
                // SignUpTwo object
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);    // By making SignUpTwo object, now we are able to go to SignUpTwo page by clicking Next Button. And also passing Formno in the Object.
                                 // Why we have pass String formno because we have generated random formno here, same formno i need in SignUpTwo Page also.
                                 // By which i will be able to interrelate the data of SignUpOne page & SignUpTwo Page that the data is of same person. That's why i need primary key(i.e formno).
            
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignUpOne(); 
    }
}
// Code by:- Vivek Auti