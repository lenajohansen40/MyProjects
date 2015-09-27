/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author udit
 */
public class DataBaseConnectivity {
    static Connection con;
	static{
		try{
			System.out.print("Connection DOne:");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		con=DriverManager.getConnection(url,"Project","project");
		System.out.print("Connection DOne:");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static int updateData(String q)
	{
		try{
		Statement st=con.createStatement();
		int ur=st.executeUpdate(q);
		return ur;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public static ResultSet selectData(String q)
	{
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(q);
		return rs;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
