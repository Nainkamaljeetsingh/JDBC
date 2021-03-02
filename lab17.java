package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;
public class lab17 
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		try
		{
			
			Scanner sc=new Scanner(System.in);
		
			con=jdbcutil.getOracleConnection();
			 st=con.createStatement();
			 String s1="insert into jlcstudents values(99,'sri','sri@jlc.com',98989899)";
			 st.addBatch(s1);
			 String s2="insert into jlcstudents values(88,'nivas','nivas@jlc.com',98989888)";
			 st.addBatch(s2);
			 String s3="insert into jlcstudents values(77,'dande','dande@jlc.com',98989877)";
			 st.addBatch(s3);
			 String s4="insert into jlcstudents values(66,'vas','vas@jlc.com',98989866)";
			 st.addBatch(s4);
			 int []x=st.executeBatch();
			 for(int i=0;i<x.length;i++)
			 {
				 System.out.println(x[i]);
			 }
			 
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(st, con);
		}
	}

}
