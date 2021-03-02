package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;
import myfirstjdbc.jdbcutil;
public class lab10 
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the query");
			String qry=sc.nextLine(); 
			st=con.createStatement();
			boolean b1=st.execute(qry);
			if(b1)
			{
				rs=st.getResultSet();
				if(rs.next())
				{
					do
					{
						int sid=rs.getInt(1);
						String nm=rs.getString(2);
						String em=rs.getString(3);
						long phn=rs.getLong(4);
						System.out.println(sid+"  "+nm+"  "+em+"  "+phn);
					}while(rs.next());
				}else
				{
					int x=st.getUpdateCount();
					System.out.println("Result: "+x);
				}
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
