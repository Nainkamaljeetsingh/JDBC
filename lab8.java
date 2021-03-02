package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab8 
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		try
		{
			int i=1;
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the no of entries");
			int n=sc.nextInt();
			con=jdbcutil.getOracleConnection();
			while(i<n) {
			System.out.println("enter the sid");
			int sid=sc.nextInt();
			sc.nextLine();
			System.out.println("enter the name");
			String nm=sc.nextLine();
			System.out.println("enter the email");
			String eml=sc.nextLine();
			System.out.println("enter the phone no");
			long phn=sc.nextLong();
			String qry=String.format("insert into jlcstudents values(%d,'%s','%s',%d)",sid,nm,eml,phn);
			System.out.println(qry);
			st=con.createStatement();
			int x=st.executeUpdate(qry);
			if(x==1) {
				System.out.println("record inserted sucessfully");
			i++;
			}
			else
				System.out.println("record not inserted found");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}finally
		{
			jdbcutil.cleanup(st, con);
		}
	}
		

}
