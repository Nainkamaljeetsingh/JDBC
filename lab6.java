package myfirstjdbc;
import java.sql.*;
import myfirstjdbc.jdbcutil;
public class lab6 
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		try
		{
			con=jdbcutil.getOracleConnection();
            String qry="insert into jlcstudents values(67,'dande','dande@jlc.com',99887766) ";
            st=con.createStatement();
            int x=st.executeUpdate(qry);
            if(x==1)
           System.out.println("record inserted");
            else
            	System.out.println("record not inserted");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(st, con);
		}
	}

}
