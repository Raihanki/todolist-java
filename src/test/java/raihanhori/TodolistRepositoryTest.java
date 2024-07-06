package raihanhori;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import raihanhori.entity.Todolist;
import raihanhori.repository.TodolistRepository;
import raihanhori.repository.TodolistRepositoryImpl;
import raihanhori.util.DatabaseUtil;

public class TodolistRepositoryTest {
	private TodolistRepository todolistRepository;
	
	@BeforeEach
	public void setUp() {
		DataSource dataSource = DatabaseUtil.getDataSource();
		todolistRepository = new TodolistRepositoryImpl(dataSource);
	}
	
	@Test
	@Disabled
	public void testCreateTask() {
		Todolist task = new Todolist("Learn Laravel");
		todolistRepository.createTask(task);
		
		Assertions.assertNotNull(task.getId());
	}
	
	@Test
	@Disabled
	public void testGetTaskById() {
		Todolist task = todolistRepository.getTaskById(1);
		Assertions.assertNotNull(task.getId());
	}
	
	@Test
	@Disabled
	public void testGetAllTask() {
		List<Todolist> tasks = todolistRepository.getAllTask();
		Assertions.assertEquals(true, tasks.size() > 0);
	}
	
	@Test
	@Disabled
	public void testDeleteTask() {
		todolistRepository.deleteTask(1);
	}
}
