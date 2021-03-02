package myfirstjdbc;
import java.sql.*;
import myfirstjdbc.jdbcutil;
import java.io.*;
import java.util.*;
public class lab30 
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE FILE NAME WITH PATH");
		String filename=sc.nextLine();
		String absfilename=filename;
		StringTokenizer tok=new StringTokenizer(filename,"//");
		while(tok.hasMoreTokens())
		filename=tok.nextToken();
		Connection con=null;
		PreparedStatement ps=null;
		FileInputStream fis=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			String sql="insert into datatable values(?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, filename);
			File image=new File(absfilename);
			fis=new FileInputStream(image);
			ps.setBinaryStream(2, fis,(int)image.length());
			ps.execute();
			System.out.println("inserted sucess");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			jdbcutil.cleanup(ps, con);
			if(fis!=null)
			{
				
			
			try
			{
				fis.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
}