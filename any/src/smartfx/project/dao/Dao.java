package smartfx.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	private static Connection connection=null;
	Dao(){}
	public static Connection getConnection() throws Exception {
		try {

			Class.forName ("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection ("jdbc:mysql://sql11.freemysqlhosting.net/sql11437410?serverTimezone=UTC", "sql11437410", "luKlE5ZCre");
			return connection;
		}catch(ClassNotFoundException e) {
			throw new Exception("ClassNotFoundException:'" + e.getMessage () + " ' ");
		}catch(SQLException e) {
			throw new Exception("SQLException : Connection Failed" +e.getMessage());
		}

	}


}
