package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	//Obt�m conex�o com o banco de dados
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/nomeBanco?user=root&password=root");
	}
}
