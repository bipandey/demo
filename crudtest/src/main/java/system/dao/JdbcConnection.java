package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JdbcConnection {
	protected Connection conn = null;
	protected ResultSet rs = null;
	protected PreparedStatement stmt = null;

	private static final String Jdbc_Driver = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=yes)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=NVMNSDBD1.D2HAWKEYE.NET)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=d2he)))";
	private static final String PASS = "oracle";
	private static final String USER = "i82718";

	JdbcConnection() {
		if (conn == null) {
			conn = getJdbcConnection();
		}
	}
	protected Connection getJdbcConnection() {

		try {
			Class.forName(Jdbc_Driver);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	protected void closeResources() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (conn != null) {
			rs.close();
		}
		if (conn != null) {
			stmt.close();
		}
	}

	abstract Connection getDbConnection();
}

