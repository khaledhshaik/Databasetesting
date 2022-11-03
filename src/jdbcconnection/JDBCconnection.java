package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/QedgeDB", "root", "Shakhal@9");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from Employeeinfo where name='Sameer'");
		while(rs.next())
		{
		System.out.println(rs.getString("Name"));
		System.out.println(rs.getString("ID"));
		System.out.println(rs.getString("Location"));
		System.out.println(rs.getString("Age"));
		}

	}

}