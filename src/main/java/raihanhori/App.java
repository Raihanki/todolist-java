package raihanhori;

import javax.sql.DataSource;

import raihanhori.repository.TodolistRepository;
import raihanhori.repository.TodolistRepositoryImpl;
import raihanhori.service.TodolistService;
import raihanhori.service.TodolistServiceImpl;
import raihanhori.util.DatabaseUtil;
import raihanhori.view.TodolistView;

public class App 
{
    public static void main(String[] args) {
		DataSource dataSource = DatabaseUtil.getDataSource();
		
		TodolistRepository todolistRepository = new TodolistRepositoryImpl(dataSource);
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
		TodolistView todolistView = new TodolistView(todolistService);
		
		todolistView.showTodolist();
	}
}
