package myfirstjdbc;
import java.sql.*;
import myfirstjdbc.jdbcutil;
public class lab7 
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			String qry="select * from jlcstudents";
			st=con.createStatement();
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				do
				{
					int sid=rs.getInt(1);
					String nm=rs.getString(2);
					String eml=rs.getString(3);
					Long phn=rs.getLong(4);
					System.out.println(sid+"  "+nm+"  "+eml+"  "+phn);
				}while(rs.next());
			}else
				System.out.println("no record found");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(rs, st, con);
	 	}
	}

}
