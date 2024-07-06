package raihanhori.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
	private static HikariDataSource hikariDataSource;
	
	static {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/java_todolist");
		config.setUsername("root");
		config.setPassword("");
		
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(4);
		config.setMaxLifetime(60 * 60 * 60_000);
		config.setIdleTimeout(60_000);
		
		hikariDataSource = new HikariDataSource(config);
	}
	
	public static HikariDataSource getDataSource() {
		return hikariDataSource;
	}
}
