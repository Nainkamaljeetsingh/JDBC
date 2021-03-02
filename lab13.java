package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab13 
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
			System.out.println("enter the query");
			String qry=sc.nextLine();
			ps=con.prepareStatement(qry);
			boolean b=ps.execute();
			if(b)
			{
				rs=ps.getResultSet();
				if(rs.next())
				{
					do {
					int id=rs.getInt(1);
					String nm=rs.getString(2);
					String em=rs.getString(3);
					long ph=rs.getLong(4);
					System.out.println(id+"  "+nm+"  "+em+"  "+ph);
					}while(rs.next());
				}
			}
			else
			{
				int x=ps.getUpdateCount();
				System.out.println("result:"+x);
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
