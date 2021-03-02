package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab18 
{
	public static void main(String []args)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			String sql="insert into jlcstudents(sid,sname) values(?,?)";
			ps=con.prepareStatement(sql);
			Scanner sc=new Scanner(System.in);
			char choice='Y';
			do
			{
				System.out.println("enter the name");
			    String nm=sc.nextLine();
			    System.out.println("enter the id");
			    int id=sc.nextInt();
			    ps.setInt(1, id);
			    ps.setString(2, nm);
			    ps.addBatch();
			    System.out.println("do u want to add more :");
			    sc.nextLine();
			    choice=sc.nextLine().charAt(0);
				
			}while(choice=='Y');
			int res[]=ps.executeBatch();
			System.out.println("hello");
			for(int i=0;i<res.length;i++)
			{
				System.out.println("result: "+res[i]);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcutil.cleanup(ps, con);
		}
	}
}
