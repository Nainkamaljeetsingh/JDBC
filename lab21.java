package myfirstjdbc;
import java.sql.*;
import myfirstjdbc.jdbcutil;
public class lab21 
{
	public static void main(String []args) throws Exception
	{
		Connection con=jdbcutil.getOracleConnection();
		DatabaseMetaData md=con.getMetaData();
		System.out.println("url: "+md.getURL());
		System.out.println("user:" +md.getUserName());
		System.out.println("Major version: "+md.getDatabaseMajorVersion());
		System.out.println("Minor version: "+md.getDatabaseMinorVersion());
		System.out.println("Full join :"+md.supportsFullOuterJoins());
		System.out.println("product name: "+md.getDatabaseProductName());
		System.out.println("Multiple rs: "+md.supportsMultipleOpenResults());
		System.out.println("DB:"+md.getDatabaseProductName());
		
		
	}

}
