package beans;

public class SEmployee extends Employee {

	private String tools;
	
	public SEmployee() {
		// TODO Auto-generated constructor stub
	}

	public SEmployee(int id, String name, String email, int salary, String tools) {
		super(id, name, email, salary);
		this.tools=tools;
		// TODO Auto-generated constructor stub
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}
	
	
	
	
	
}
