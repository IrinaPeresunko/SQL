package createDatabase;

import java.sql.*;

public class CreateDatabase {
	public static void main(String[] args){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "password");
			String guery = "Select * FROM users";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(guery);
			while(rs.next()){
				System.out.println(rs.getString("id")+" " + rs.getString("name")+ " "+rs.getString("age"));
			}
		//	System.out.println("good");
		}catch(Exception e){
			System.err.println(e);
		}
	}	
}