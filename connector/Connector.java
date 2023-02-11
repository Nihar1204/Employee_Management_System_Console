package connector;
import java.sql.*;
public class Connector {
	static Connection con;
	static public Connection getCon()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","Nihar@123#");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
