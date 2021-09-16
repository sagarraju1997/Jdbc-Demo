package jdbc;

import java.sql.*;

/*
1. Import --java.sql
2. Load & Register the Driver
3. Create a Connection
4. Create a Statement
5. Execute a query
6. Process the result
7. Close
*/

public class jdbcDemo {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/my_web";
		String uName = "root";
		String pass = "sonuraju";
		String query = "select * from users";
		//select first_name from users where email_id='abc'
		
		//JDBC driver manager can detect and load the driver automatically.
		//Class.forName("com.mysql.jdbc.Driver");		//Load & Register the Driver
		
		Connection conn = DriverManager.getConnection(url, uName, pass);
		Statement st = conn.createStatement();		//PraparedStatement
		
		//DDL -- 
		//DML -- int executeUpdate()
		//DQL -- ResultSet executeQuery()
		ResultSet rs = st.executeQuery(query);//DDL,DML,DQL
		
		while(rs.next()) {
			String email =rs.getString("email_id");
			System.out.println(email);
		}
		st.close();
		conn.close();
	}

}
