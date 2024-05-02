package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener {
    
    
    JTextField panTextField, aadhaarTextField;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, eduQualificationComboBox, occupationComboBox;
    JButton next;
    JRadioButton sYes, sNo, eYes, eNo;
    String formno;
    
    // For passing String formno in SignUpTwo page , we have to pass with contructor only. Otherwise it will throw error.
    SignUpTwo(String formno) {
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[]={"Hindu", "Muslim", "Sikh", "Christain", "Other"};      //Array is made used to pass in religion object for dropdown options.
        religionComboBox = new JComboBox(valReligion);          // It is used for DropDown Field.
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);
        
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valCategory[]={"General", "OBC", "SC", "ST", "Other"};      //Array is made used to pass in religion object for dropdown options.
        categoryComboBox = new JComboBox(valCategory);          // It is used for DropDown Field.
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);
        
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valIncome[]={"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "> 8,00,000"};      //Array is made used to pass in religion object for dropdown options.
        incomeComboBox = new JComboBox(valIncome);          // It is used for DropDown Field.
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);
        
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        String valEduQualification[]={"Graduate", "Non-Graduate", "Post-Graduate", "Doctrate", "Others"};      //Array is made used to pass in religion object for dropdown options.
        eduQualificationComboBox = new JComboBox(valEduQualification);          // It is used for DropDown Field.
        eduQualificationComboBox.setBounds(300, 315, 400, 30);
        eduQualificationComboBox.setBackground(Color.WHITE);
        add(eduQualificationComboBox);
        
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String valOccupation[]={"Salaried", "Self-Employed", "Business", "Defence", "Student", "Retired", "Others"};      //Array is made used to pass in religion object for dropdown options.
        occupationComboBox = new JComboBox(valOccupation);          // It is used for DropDown Field.
        occupationComboBox.setBounds(300, 390, 400, 30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);
        
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        //JTextField panTextField = new JTextField();
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        
        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaar.setBounds(100, 490, 200, 30);
        add(aadhaar);
        
        //JTextField aadhaarTextField = new JTextField();
        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhaarTextField.setBounds(300, 490, 400, 30);
        add(aadhaarTextField);
        
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);
        
        //JRadioButton sYes = new JRadioButton("Yes");
        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 540, 60, 30);
        sYes.setBackground(Color.WHITE);
        add(sYes);
        
        //JRadioButton sNo = new JRadioButton("No");
        sNo = new JRadioButton("No");
        sNo.setBounds(450, 540, 120, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();    // ButtonGroup allows user to choose either YES or NO, can't choose both.
        seniorCitizenGroup.add(sYes);
        seniorCitizenGroup.add(sNo);
        
        
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);
        
        //JRadioButton eYes = new JRadioButton("Yes");
        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 590, 60, 30);
        eYes.setBackground(Color.WHITE);
        add(eYes);
        
        //JRadioButton eNo = new JRadioButton("No");
        eNo = new JRadioButton("No");
        eNo.setBounds(450, 590, 120, 30);
        eNo.setBackground(Color.WHITE);
        add(eNo);
        
        ButtonGroup existingAccounGroup = new ButtonGroup();    // ButtonGroup allows user to choose either YES or NO, can't choose both.
        existingAccounGroup.add(eYes);
        existingAccounGroup.add(eNo);
        
        
        
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
        
        // getText Method is used to extract the value from TextField.
        String religion = (String) religionComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String eduQualification = (String) eduQualificationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String pan_no = panTextField.getText();
        String aadhaar_no = aadhaarTextField.getText();
        String seniorCitizen = null;
        if(sYes.isSelected()){
            seniorCitizen = "Yes";
        }else if (sNo.isSelected()){
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if(eYes.isSelected()){
            existingAccount = "Yes";
        }else if (eNo.isSelected()){
            existingAccount = "No";
        }
        
        
        //Now, we need to hit in the database.
        //Database is external entity so, need to perform exception handling.Because Error occurring chances are there at Runtime.
        try {
            
                //Call the database. For that, first we need to establish a connection with mysql
                //After Connection, we are able to run the query of mysql
                Conn c = new Conn();     //c object is made of Conn class.
                String query = "insert into signup2 values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+eduQualification+"', '"+occupation+"', '"+pan_no+"', '"+aadhaar_no+"', '"+seniorCitizen+"', '"+existingAccount+"')";            // Here, we trying to insert the data into mysql. By using DML, insert Command.
                                                      //  "String'"+variable+"'String"
                //4. Execute Query
                // Statement s which was created in Conn class is used to Execute Query.
                c.s.executeUpdate(query);   // This is a DML Command, executeUpdate function is used by passing Query in it.
                // So, By this, our query will run in mysql.
                
                // SignUpThree Object
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
                
            }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignUpTwo("");    // we don't have any default constructor, so need to pass empty String.
    }
}
// Code by:- Vivek Auti