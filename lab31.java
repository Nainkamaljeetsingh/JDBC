package myfirstjdbc;
import java.sql.*;
import javax.sql.*;
import myfirstjdbc.jdbcutil;
public class lab31
{
	public static void main (String []args)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			String sql="insert into simple values(?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, "nain");
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
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