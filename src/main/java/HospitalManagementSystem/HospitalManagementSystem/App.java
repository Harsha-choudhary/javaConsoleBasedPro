package HospitalManagementSystem.HospitalManagementSystem;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException{
  /*  {
        System.out.println( "Hello World!" );
        Menu menu=new Menu();
        menu.displayMenu();
    }*/
}
}
/*
*//**
	 * Hello world!
	 *
	 *//*
		 * public class App { public static void main( String[] args ) throws
		 * IOException { System.out.println( "Hello World!" ); String url
		 * ="jdbc:mysql://localhost:3306/employee"; try { Connection con =
		 * DriverManager.getConnection(url, "root", "Harsha@1810"); Statement
		 * stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.
		 * CONCUR_UPDATABLE ); // Statement st =con.createStatement();
		 * 
		 * //int i =
		 * stmt.executeUpdate("INSERT INTO  doctors VALUES (3 ,'yogesh', 'neurolgist')")
		 * ; // int j =
		 * stmt.executeUpdate("UPDATE doctors  SET name  = 'ram' WHERE  name='bhavna'");
		 * // int k =
		 * stmt.executeUpdate("update doctors set specialization = 'dentist' where id=3"
		 * ); //int l = stmt.executeUpdate("delete from doctors where id = 3");
		 * //System.out.println(l);
		 * 
		 * //preparedstatement
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //ResultSet rs=stmt.executeQuery("select * from doctors");
		 * 
		 * // while(rs.next()) //{ // int id=rs.getInt(1);//rs.getInt("bid") // String
		 * name=rs.getString("name");//or rs.getString(2) // String
		 * specialization=rs.getString("specialization");
		 * 
		 * // System.out.println("id :"+id); // System.out.println("name :"+name); //
		 * System.out.println("specailzation :"+specialization); //
		 * System.out.println("...................................................");
		 * //}
		 * 
		 * //rs.previous(); // int id=rs.getInt(1); // String
		 * name=rs.getString("name");// // String specialization=rs.getString(3);
		 * 
		 * // System.out.println("id :"+id); //System.out.println("name :"+name); //
		 * System.out.println("specialization :"+specialization); //
		 * System.out.println("...................................................");
		 * 
		 * 
		 * // }
		 * 
		 * 
		 * 
		 * PreparedStatement pstmt = con.prepareStatement(
		 * "INSERT INTO employee (eid, ename, contact, salary) VALUES (?, ?, ?, ?)" );
		 * 
		 * 
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * 
		 * 
		 * System.out.println("Enter eid:"); int eid = Integer.parseInt(br.readLine());
		 * 
		 * System.out.println("Enter ename:"); String ename = br.readLine();
		 * 
		 * System.out.println("Enter contact:"); long contact =
		 * Long.parseLong(br.readLine());
		 * 
		 * System.out.println("Enter salary:"); int salary =
		 * Integer.parseInt(br.readLine());
		 * 
		 * 
		 * pstmt.setInt(1, eid); pstmt.setString(2, ename); pstmt.setLong(3, contact);
		 * pstmt.setInt(4, salary);
		 * 
		 * // Execute insert query int rowsInserted = pstmt.executeUpdate();
		 * System.out.println(rowsInserted + " record(s) inserted successfully.");
		 * 
		 * 
		 * Statement st = con.createStatement(); ResultSet rs =
		 * st.executeQuery("SELECT * FROM employee");
		 * 
		 * System.out.println("\nEmployee Records:"); while (rs.next()) {
		 * System.out.println("eid: " + rs.getInt("eid")); System.out.println("ename: "
		 * + rs.getString("ename")); System.out.println("contact: " +
		 * rs.getLong("contact")); System.out.println("salary: " + rs.getInt("salary"));
		 * System.out.println("----------------------------------------------"); } }
		 * 
		 * catch (SQLException e) { e.printStackTrace(); }
		 * 
		 * 
		 * } }
		 * 
		 */