package myfirstjdbc;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;
import myfirstjdbc.jdbcutil;
import oracle.jdbc.internal.OracleTypes;
public class lab16 
{
	public static void main(String []args)
	{
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			cs=con.prepareCall(" open students for select *from students");
			cs.registerOutParameter(1,OracleTypes.CURSOR);
			cs.execute();
			rs=(ResultSet)cs.getObject(1);
			if(rs.next())
			{
				do
				{
					int id=rs.getInt(1);
					String nm=rs.getString(2);
					float fee=rs.getFloat(3);
					System.out.println(id+"  "+nm+"  "+fee);
				}while(rs.next());
			}else
			{
				System.out.println("no record found");
			}
		}catch(SQLException e)
		{
			System.out.println("error in calling");
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(rs, cs, con);
		}
	}

}
