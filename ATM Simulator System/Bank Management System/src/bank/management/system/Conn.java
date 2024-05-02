package bank.management.system;

import java.sql.*;

//There are 5 Steps in JDBC Connectivity:-
//1. Register the Driver
//2. Create Connection
//3. Create Statement
//4. Execute Query
//5. Close Connection

public class Conn {
    
    Connection c;   // Globally Object is made Connection c.
    Statement s;    // Statement s is declared.
    
    public Conn(){
        // We need to do Error Handling because mysql is External Entity ,so there are some chances of ocurring error.
        // Runtime Error might come. So to catch Runtime Error, Exception Handling is done.
        try {
            //1. Register the Driver (By importing mysql-connector library, Now we don't need to register manually)
            //Class.forName(com.mysql.cj.jdbc.Driver);   // We have class named as Class, in which static method is present i.e forName and rest is the Driver's Name.
            
            //2.Create Connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","17102003");    // DriverManager class is used for Connection using getConnection method. And in closed bracket (URL string is mentioned).
            
            //3.Create Statement
            s = c.createStatement();
            
            //4.Execute Query is done on SignUpOne Page.
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
// Code by:- Vivek Auti