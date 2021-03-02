package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab9 
{
	public static void main(String []args )
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid");
			int sid=sc.nextInt();
			String qry=String.format("select * from jlcstudents where sid=%d",sid);
			st=con.createStatement();
			 rs=st.executeQuery(qry);
			 if(rs.next())
			 {
				 int id=rs.getInt(1);
				 String name=rs.getString(2);
				 String email=rs.getString(3);
				 Long phn=rs.getLong(4);
				 System.out.println(id+"  "+name+"  "+email+"  "+phn);
			 }
			 else
			 {
				 System.out.println("sorry! no student found with the given sid ");
			 }
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(rs, st, con);
		}
	}

}
