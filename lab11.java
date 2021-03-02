package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab11 
{
	public static void main(String []args)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid ");
			int sid=sc.nextInt();
			sc.nextLine();
			System.out.println("enter the name");
			String nm=sc.nextLine();
			System.out.println("enter the email");
			String eml=sc.nextLine();
			System.out.println("enter the ph no");
			long ph=sc.nextLong();
			String qry="insert into jlcstudents values(?,?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setInt(1, sid);
			ps.setString(2, nm);
            ps.setString(3, eml);
            ps.setLong(4, ph);
            int x=ps.executeUpdate();
            if(x==1)
            {
            	System.out.println("record inserted succesfully");
            }else
            	System.out.println("record not submitted");
            
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(ps, con);
		}
	}
}
