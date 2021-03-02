package myfirstjdbc;
import java.sql.*;
public class lab1
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:odbc:Nainkamal","system","Nksingh1998");
			String sql="insert into jlcstudents values(99,'sri','sri@jlc',65799999)";
			st=con.createStatement();
			int x=st.executeUpdate(sql);
			if(x==1)
			{
				System.out.println("record inserted");
				
			}
			else
			{
				System.out.println("record not inserted");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}

