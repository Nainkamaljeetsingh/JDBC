package myfirstjdbc;
import java.sql.*;
import java.util.Scanner;
public class lab15 
{
	public static void main(String []args)
	{
		Connection con=null;
		CallableStatement cs=null;
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid ");
			int sid=sc.nextInt();
			System.out.println("enter the installments");
			float ins=sc.nextFloat();
			con=jdbcutil.getOracleConnection();
			cs=con.prepareCall("call updateInfo(stid IN int,nm OUT varchar,Inc ");
			cs.setInt(1, sid);
			cs.setFloat(3,ins);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.execute();
			String nm=cs.getString(2);
			float fee=cs.getFloat(3);
			System.out.println(nm+" "+fee);
			System.out.println("called sucessfully");
			
		}catch(SQLException e)
		{
			System.out.println("error in calling ");
			e.printStackTrace();
		}
	}

}
