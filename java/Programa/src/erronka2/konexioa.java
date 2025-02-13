package erronka2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class konexioa {

	private static String db_ = "2erronka";
	private static String login_ = "administratzailea";
	private static String password_ = "1234";
	private static String url_ = "jdbc:mysql://172.16.237.150/" + db_;
	private static Connection connection_;
	private static Statement st_ = null;

	public konexioa() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			setConnection_(DriverManager.getConnection(url_, login_, password_));

			if (getConnection_() != null) {
				
				System.out.println("Datu baseetara konexioa eginda.");
				
			} else {
				System.out.println("Arazoak konexioan.");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static Connection getConnection_() {
		return connection_;
	}

	private static void setConnection_(Connection connection_) {
		konexioa.connection_ = connection_;
	}
}
