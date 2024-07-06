package raihanhori.service;

import java.util.List;

import raihanhori.entity.Todolist;
import raihanhori.repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {
	
	private TodolistRepository todolistRepository;
	
	public TodolistServiceImpl(TodolistRepository todolistRepository) {
		this.todolistRepository = todolistRepository;
	}

	@Override
	public void createTask(String task) {
		todolistRepository.createTask(new Todolist(task));
		System.out.println(task + " successfully created");
	}

	@Override
	public void getAllTask() {
		System.out.println("");
		System.out.println("TODOLIST");
		List<Todolist> tasks = todolistRepository.getAllTask();
		for (Todolist task : tasks) {
			System.out.println(task.getId() + ". " + task.getTask());
		}
	}

	@Override
	public void deleteTask(Integer id) {
		todolistRepository.deleteTask(id);
		System.out.println("successfully deleted");
	}
	
}
