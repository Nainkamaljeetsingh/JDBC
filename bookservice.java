package myfirstjdbc;
import java.sql.*;
import java.util.*;
import java.util.*;
import myfirstjdbc.jdbcutil;
public class bookservice 
{
	public boolean verifyUser(String un,String pw)
	{
		boolean valid=false;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("Select * from users_table where username=? and password=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			rs=ps.executeQuery();
			if(rs.next())
				valid=true;
		}catch(Exception e)
		{
			System.out.println(e);
		}finally
		{
			jdbcutil.cleanup(rs, ps, con);
		}return valid;
		
	}
	public int deleteBook(String bid)
	{
		int x=0;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("delete from jlcbooks where bid=?");
			ps.setString(1, bid);
			x=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}finally
		{
			jdbcutil.cleanup(ps, con);
		}return x;
		
	}
	public boolean addBook(books bo)
	{
		boolean added =false;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("insert into jlcbooks values(?,?,?,?,?,?)");
			ps.setString(1,getNewBookId());
			ps.setString(2, bo.getBname());
			ps.setString(3, bo.getAuthor());
			ps.setString(4, bo.getPublication());
			ps.setLong(5, bo.getCost());
			ps.setInt(6, bo.getEdition());
			ps.executeUpdate();
			added=true;
		}catch(Exception e)
		{
			System.out.println(e);
			
		}finally
		{
			jdbcutil.cleanup(ps, con);
		}return added;
	}
	public int updateBook(books bo)
	{
		int x=0;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=jdbcutil.getOracleConnection();
		ps=con.prepareStatement("update jlcbooks set bname=?,author=?,publication=?,cost=?,edition=? where bid=?");
		ps.setString(1, bo.getBname());
		ps.setString(2, bo.getAuthor());
		ps.setString(3, bo.getPublication());
		ps.setLong(4, bo.getCost());
		ps.setInt(5, bo.getEdition());
		ps.setString(6, bo.getBid());
		x=ps.executeUpdate();
		
		}catch(Exception e)
		{
			System.out.println(e);
			
		}finally
		{
			jdbcutil.cleanup(ps, con);
		}return x;
	}
	public books getBookByBid(String bid)
	{
		books bo=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("select * from jlcbooks where bid=?");
			ps.setString(1, bid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				bo=getBookFromResultSet(rs);
				
			}
		}catch(Exception e)
			{
				System.out.println(e);
			}finally
			{
				jdbcutil.cleanup(ps, con);
			}return bo;
			
		}
	public List<books> getBookByname(String bname)
	{
		List<books> al=new ArrayList<books>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("select * from jlcbooks where bname=?");
			ps.setString(1, bname);
			rs=ps.executeQuery();
			while(rs.next())
			{
				books bo=getBookFromResultSet(rs);
				al.add(bo);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}finally
		{
			jdbcutil.cleanup(rs, ps, con);
		}return al;
	}
	public List<books> getBooksByAuthor(String author)
	{
		List<books> al=new ArrayList<books>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("select * from jlcbooks where author=?");
			ps.setString(1, author);
			rs=ps.executeQuery();
			while(rs.next())
			{
				books bo=getBookFromResultSet(rs);
				al.add(bo);				
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}finally
		{
			jdbcutil.cleanup(rs, ps, con);
		}return al;
	}
	public List<books> getBooksByCost(long cost)
	{
		List<books> al=new ArrayList<books>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("select * from jlcbooks where cost=?");
			ps.setLong(1,cost);
			rs=ps.executeQuery();
			while(rs.next())
			{
				books bo=getBookFromResultSet(rs);
				al.add(bo);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}finally
		{
			jdbcutil.cleanup(rs, ps,con);
		}return al;
		
	}
	public List<books> getAllBooks()
	{
		List<books> al=new ArrayList<books>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("select * from jlcbooks");
			rs=ps.executeQuery();
			while(rs.next())
			{
				books bo=getBookFromResultSet(rs);
				al.add(bo);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}finally
		{
			jdbcutil.cleanup(rs, ps, con);
		}return al;
	}
	private books getBookFromResultSet(ResultSet rs)throws Exception
	{
		books bo=new books();
		bo.setBid(rs.getString(1));
		bo.setBname(rs.getString(2));
		bo.setAuthor(rs.getString(3));
		bo.setPublication(rs.getString(4));
		bo.setCost(rs.getLong(5));
		bo.setEdition(rs.getInt(6));
		return bo;
	}
	private String getNewBookId()
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String bid="B-01";
		try
		{
			con=jdbcutil.getOracleConnection();
			ps=con.prepareStatement("select max(bid) from jlcbooks");
			rs=ps.executeQuery();
			if(rs.next())
			{
				bid=rs.getString(1);
			if(bid!=null)
			{
				String id=bid.substring(2);
				int x=Integer.parseInt(id);
				x++;
				if(x<10)
					bid="B-0"+x;
				else
					bid="B-"+x;
			}
			else
			  {
				bid="B-01";
			  }
		}
			
		}catch(Exception e)
		{
			System.out.println(e);
			
		}finally
		{
			jdbcutil.cleanup(rs, ps, con);
		}
		System.out.println(bid);
		return bid;
	}
	
}
