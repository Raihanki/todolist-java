package raihanhori;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import raihanhori.util.DatabaseUtil;

public class DatabaseUtilTest {
	@Test
	void testConnection() throws SQLException {
		Connection conn = DatabaseUtil.getDataSource().getConnection();
		
		conn.close();
	}
}
