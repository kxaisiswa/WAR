package db.connection;

import java.sql.*;

public class DBConnection {
	static Connection con;

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_76b5d63f29873f3";
	private static final String DB_USER = "bc595431952f6c";
	private static final String DB_PASSWORD = "729573a2";
	/*
	 * private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/users?useLegacyDatetimeCode=false&serverTimezone=UTC";
	 * private static final String DB_USER = "root";
	 * private static final String DB_PASSWORD = "";
	 */
	public static Connection getConnection() {
		try {
			Class.forName(DB_DRIVER);
			try {
				con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
				System.out.println("Connection Success");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}
}