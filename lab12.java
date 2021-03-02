package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab12 
{
	public static void main(String []args)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid ");
			int sid=sc.nextInt();
			String sql="select * from jlcstudents where sid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(3,sid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String eml=rs.getString(3);
				long ph=rs.getLong(4);
				System.out.println(id+"  "+name+"  "+eml+"  "+ph);
				

			}	else
			{
				System.out.println("record not found");
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(rs, ps, con);
		}
	}

}
