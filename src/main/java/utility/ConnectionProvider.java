

package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Implementing Singleton design pattern 
public class ConnectionProvider {

	static private Connection connection;
	
	
	public static Connection getCOnnection()
	{
		if(connection==null)
		{
			String url = "jdbc:mysql://localhost:3306/hospital";
			try {
				connection=DriverManager.getConnection(url,"root","Harsha@1810");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	

}