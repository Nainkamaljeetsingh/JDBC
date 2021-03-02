package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;

import myfirstjdbc.jdbcutil;
public class lab14 
{
	public static void main(String []args)
	{
		Connection con=null;
		CallableStatement cs=null;
		try
		{
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid");
			int sid=sc.nextInt();
			System.out.println("enter the name");
			String name=sc.next();
			System.out.println("enter the fee ");
			float fee=sc.nextFloat();
			con=jdbcutil.getOracleConnection();
			String sql="insert into students values(?,?,?)";
			cs=con.prepareCall(sql);
			cs.setInt(1, sid);
			cs.setString(2, name);
			cs.setFloat(3, fee);
			cs.execute();
			System.out.println("Called sucessfully");
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(cs, con);
		}
	}

}
