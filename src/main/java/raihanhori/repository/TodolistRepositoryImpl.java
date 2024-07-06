package raihanhori.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import raihanhori.entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {
	private DataSource dataSource;

	public TodolistRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void createTask(Todolist todolist) {
		String query = "INSERT INTO todolist (task) VALUES (?)";

		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement stat = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				stat.setString(1, todolist.getTask());
				stat.executeUpdate();

				try (ResultSet result = stat.getGeneratedKeys()) {
					if (result.next()) {
						todolist.setId(result.getInt(1));
					}
				}
			}
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public Todolist getTaskById(Integer id) {
		String query = "SELECT * FROM todolist WHERE id = ?";
		
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet result = statement.executeQuery()) {
					if (result.next()) {
						return new Todolist(
							result.getInt("id"),
							result.getString("task")
						);
					} else {
						return null;
					}
				}
			}
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public List<Todolist> getAllTask() {
		String query = "SELECT * FROM todolist";
		try (Connection conn = dataSource.getConnection()) {
			try (Statement statement = conn.createStatement()) {
				try (ResultSet result = statement.executeQuery(query)) {
					List<Todolist> tasks = new ArrayList<Todolist>();
					while(result.next()) {
						Todolist task = new Todolist(
							result.getInt("id"), 
							result.getString("task")
						);
						tasks.add(task);
					}
					return tasks;
				}
			}
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void deleteTask(Integer id) {
		String query = "DELETE FROM todolist WHERE id = ?";
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setInt(1, id);
				statement.executeUpdate();
			}
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

}
