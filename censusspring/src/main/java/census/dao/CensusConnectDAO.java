package census.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import census.entity.Member1;

public class CensusConnectDAO  {
	private final String url="jdbc:postgresql://localhost/censusdb";
	private final String user="postgres";
	private final String password="root";
	public Statement ConnectToDB() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection connection=DriverManager.getConnection(url,user,password);
		return connection.createStatement();
	}

}
