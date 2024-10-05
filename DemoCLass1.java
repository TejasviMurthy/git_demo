import java.sql.*;
public class DemoCLass1 {
	public static void main(String arr[]) throws Exception{
		String url = "jdbc:mysql://localhost:3306/school";
		String usrName = "root";
		String paws = "";
		String querry = "INSERT INTO STUDENT VALUES (?, ?, ?)";
		Connection con = DriverManager.getConnection(url, usrName, paws);
		PreparedStatement st = con.prepareStatement(querry);
		st.setInt(1, 6);
		st.setString(2, "Bhima");
		st.setInt(3, 12);
		
		int count = st.executeUpdate();
		System.out.println(count);
		
		st.close();
		con.close();
	}
}
