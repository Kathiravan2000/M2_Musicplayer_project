package kathiravan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserImpl {

	void getAllUser() throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music", "root", "kathir123");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from User");
		while (rs.next()) {
			System.out.println("new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)");
		}

		st.close();
		rs.close();
		con.close();

	}

//	void updateUser(String passcode, String username) throws Exception {
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music", "root", "12345");
//		PreparedStatement ps = con.prepareStatement("update User set passcode=? where username=?");
//		ps.setString(4, passcode);
//		ps.setString(2, username);
//		ps.executeUpdate();
//		ps.close();
//		con.close();
//
//	}

	public String addUser(int userid, String username, String emailid, String passcode) {

		String output = "";
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music", "root", "kathir123");) {

			PreparedStatement ps = con.prepareStatement("insert into User values(?,?,?,?)");
			ps.setInt(1, userid);
			ps.setString(2, username);
			ps.setString(3, emailid);
			ps.setString(4, passcode);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				output = "Account created";
			} else
				output = "Creation of account failed";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return output;
	}

	public boolean checkUser(String username, String passcode) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Music", "root", "kathir123");
		PreparedStatement statement = con.prepareStatement("select * from User where username=? and passcode=?");
		statement.setString(1, username);
		statement.setString(2, passcode);
		ResultSet rs = statement.executeQuery();
		boolean validation = true;
		if (rs.next()) {
			validation = true;
		} else {
			validation = false;
		}
		return validation;
	}

}
