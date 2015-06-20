package createDatabase;

import java.sql.*;

public class CreateDatabase {
	
	private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
	private static String NAME = "root";
	private static String PASSWORD = "password";
	private static String query;
	private static Statement statement;
	private static Connection connection;
	
	public static void print(int id,String name, int age, String email){
		System.out.println("\t"+"|id:"+id+" | name:"+name+" | age:"+age+" | email:"+email);
	}
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,NAME,PASSWORD);
			System.out.println("Connected");
			
			query = "Select * FROM users WHERE age>20 AND age<45";
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String email = resultSet.getString("email");
				print(id,name,age,email);
			}
			
			connection.close();
		}catch(Exception e){
			System.err.println(e);
		}
		finally{
			if(statement!=null){
				try{
					statement.close();
				}catch(Exception e){System.err.println(e);}
			}
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception e){System.err.println(e);}
			}
		}
	}	
}