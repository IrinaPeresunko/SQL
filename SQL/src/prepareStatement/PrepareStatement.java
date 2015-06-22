package prepareStatement;

import java.sql.*;

public class PrepareStatement {
	
	private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
	private static String NAME = "root";
	private static String PASSWORD = "password";
	private static PreparedStatement prepareStatement;
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
			
			statement = connection.createStatement();
			prepareStatement = connection.prepareStatement("Select * FROM users WHERE age>? AND age<?");
			prepareStatement.setInt(1, 20);
			prepareStatement.setInt(2,45);
			
			ResultSet resultSet = prepareStatement.executeQuery();
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