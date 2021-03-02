package myfirstjdbc;
import java.sql.*;
public class jdbcutil 
{
	static 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public static Connection getOracleConnection()throws SQLException
	{
		String url="jdbc:oracle:thin:@localhost:1521:Nainkamal";
		Connection con=DriverManager.getConnection(url,"system","Nksingh1998");
		return con;
	}
	public static void cleanup(Statement st,Connection con)
	{
		try
		{
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
	}
	public static void cleanup(ResultSet rs,Statement st,Connection con)
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

