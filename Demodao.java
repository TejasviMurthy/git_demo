import java.sql.*;
public class Demodao {
	public static void main(String arr[]) throws Exception {
		studentDAO std = new studentDAO();
		student s1  = std.getName(8);
		System.out.println(s1.name);
		
		student s2 = new student();
		s2.id = 9; 
		s2.name = "Kunthi";
		s2.Class = 19;
		
		int count = std.insert(s2);
		System.out.println(count+" rows affected");
		
		
	}
}

class studentDAO{
	Connection con = null;
	Statement st = null;
	public void conect() throws Exception{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");
		st = con.createStatement();
	}
	public student getName(int id) throws Exception {
		student s1 = new student();
		conect();
		ResultSet rs = st.executeQuery("SELECT NAME FROM STUDENT WHERE ID = "+id);
		rs.next();
		s1.name =  rs.getString("NAME");
		return s1;
	}
	
	public int insert(student s2) throws Exception{
		String query = "INSERT INTO STUDENT VALUE (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query); 
		pstmt.setInt(1, s2.id);
		pstmt.setString(2, s2.name);
		pstmt.setInt(3, s2.Class);
		int count = pstmt.executeUpdate();
		return count; 
	}
}
class student{
	int id;
	String name;
	int Class;
}
