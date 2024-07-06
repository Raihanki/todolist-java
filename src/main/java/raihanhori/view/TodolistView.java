package raihanhori.view;

import java.util.Scanner;

import raihanhori.service.TodolistService;

public class TodolistView {
	private TodolistService todolistService;
	private Scanner scanner = new Scanner(System.in);
	
	public TodolistView(TodolistService todolistService) {
		this.todolistService = todolistService;
	}
	
	public void showTodolist() {
		todolistService.getAllTask();
		
		while (true) {
			System.out.println("--------------------");
			System.out.println("Menu");
			System.out.println("1. Add Todo");
			System.out.println("2. Delete Todo");
			System.out.println("3. Exit App");
			
			System.out.print("Choose One : ");
			String choise = this.scanner.nextLine();
			
			if (choise.equals("1")) {
				this.showCreateTodo();
			} else if (choise.equals("2")) {
				this.showDeleteTodo();
			} else if (choise.equals("3")) {
				break;
			} else {
				System.out.println("Invalid Choises");
				break;
			}
		}
	}
	
	public void showCreateTodo() {
		System.out.print("Type Your Todo : ");
		String todo = this.scanner.nextLine();
		
		todolistService.createTask(todo);
		this.showTodolist();
	}
	
	public void showDeleteTodo() {
		System.out.print("Choose ID : ");
		Integer todo = this.scanner.nextInt();
		
		todolistService.deleteTask(todo);
		this.showTodolist();
	}
}
