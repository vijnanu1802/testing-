package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

class updatedatabase{
	String url="jdbc:mysql://localhost:3306/madusudhan";
	String username="root";
	String password="root";
	String driver="com.mysql.jdbc.Driver";
	PreparedStatement ps;
	Statement stmt;
	public void connectiondatabase(){
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);  
			System.out.println("Coneection established");
			String quiry="update employee set empname=? where empid=?";			
			ps= con.prepareStatement(quiry);
			ps.setString(1,"madhu");
			ps.setInt(2,4);
			int i=ps.executeUpdate();
			System.out.println(i+"   rows are affected");
			 con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class preparedupdate {
	public static void main(String[] args) {
		updatedatabase u=new updatedatabase();
		u.connectiondatabase();
	}

}