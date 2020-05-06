package beans;

public class Employee {
    private int id;
    private String name,email;
    
    
    public Employee() {
		// TODO Auto-generated constructor stub
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getName() {
		return name;
	}
    
    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    public String getEmail() {
		return email;
	}
    
}
