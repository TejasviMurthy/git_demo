import java.sql.*;
public class DemoClass {
	public static void main(String arr[]) throws Exception {
		String url = "jdbc:mysql://localhost:3306/school";
		String userName = "root";
		String password = "";
//		int id = 11;
//		String name = "Rohith";
//		int Class = 13;
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		
		
//		Statement st = con.createStatement();
		
		
//		ResultSet rs = st.executeQuery("SELECT NAME FROM STUDENT WHERE ID = 1");// fetch the data
//		while(rs.next()) {
//			System.out.println( rs.getString("NAME") );
//		}
		
//		
//		int count = st.executeUpdate("INSERT INTO STUDENT VALUE (" +id +",'"+name +"',"+Class+")"); // UPDATE or INSERT THE DATA
//		System.out.println(count + "rows affected");
		
		
		PreparedStatement st = con.prepareStatement("UPDATE STUDENT SET CLASS = ? WHERE ID = ?");
		st.setInt(1, 12);
		st.setInt(2, 2);
		
		int count = st.executeUpdate();
		System.out.println(count + " rows affected");
		st.close();
		con.close();
	}
}

