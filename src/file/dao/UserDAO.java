package file.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.connection.DBConnection;
import file.model.User;

public class UserDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	
	int sid;
	String name, email;
	
	public static List<User> listuser() {
		List<User> user = new ArrayList<User>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM person");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				
				user.add(u);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void insertuser(User user) {
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO person (name, email) VALUES(?, ?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteuser(int delid) {
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM person WHERE id = ?");
			ps.setInt(1, delid);
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User viewuser(int updid) {
		User user = new User();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM person WHERE id = ?");
			ps.setInt(1, updid);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateuser(User user) {
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("UPDATE person SET name = ?, email = ? WHERE id = ?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getId());
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
