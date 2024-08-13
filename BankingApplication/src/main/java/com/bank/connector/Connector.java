package com.bank.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	static String url="jdbc:mysql://localhost:3306/bank";
    static String user="root";
    static String password="tiger";
    static Connection con=null;
    public static Connection requestConnection() 
    {
   	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
   	 return con;
   	 
   	 
   	 
    }

}
