package raihanhori.service;

import java.util.List;

import raihanhori.entity.Todolist;

public interface TodolistService {
	void createTask(String task);
	
	void getAllTask();
	
	void deleteTask(Integer id);
}
