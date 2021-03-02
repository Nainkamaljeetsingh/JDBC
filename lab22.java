package myfirstjdbc;
import java.sql.*;
import myfirstjdbc.jdbcutil;
public class lab22 
{
	public static void main(String []args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select sid,sname,email,phone from jlcstudents");
			System.out.println("** ALL RECORD**");
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getLong(4));
			System.out.println("**INSERTING RECORD**");
			rs.moveToInsertRow();
			rs.updateInt(1,999);
			rs.updateLong(4, 56565656);
			rs.insertRow();
			System.out.println("Record inserted");
			System.out.println("updating second record");
			rs.absolute(2);
			rs.updateString(2, "manish");
			rs.updateString(3, "mainish@.com");
			rs.updateLong(4, 21212121);
			rs.updateRow();
			System.out.println("Record updateed ");
			System.out.println("Deleting 3rd record");
			rs.absolute(3);
			rs.deleteRow();
			System.out.println("record deleted");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(rs, st, con);
		}
	}

}
