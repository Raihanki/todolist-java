package raihanhori.entity;

public class Todolist {
	private Integer id;
	private String task;
	
	public Todolist() {
		
	}
	
	public Todolist(String task) {
		this.task = task;
	}
	
	public Todolist(Integer id, String task) {
		this.id = id;
		this.task = task;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	
}
