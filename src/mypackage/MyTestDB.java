package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyTestDB
{
	public static void testdb1()
	{
		String dbDriver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mytestdb";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(url,"root","123456");
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from info;");
			while(rs.next())
			{
				System.out.println("test DB:id="+rs.getString(1)+",name="+rs.getString(2));
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		//System.out.println("test DB:");
		testdb1();
	}
}
