package raihanhori.repository;

import java.util.List;

import raihanhori.entity.Todolist;

public interface TodolistRepository {
	void createTask(Todolist todolist);
	
	Todolist getTaskById(Integer id);
	
	List<Todolist> getAllTask();
	
	void deleteTask(Integer id);
}
