package beans;

public class Student {
    private int id;
    private String name,email;
    private int marks;
    
    public Student() {
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
    
    public void setMarks(int marks) {
		this.marks = marks;
	}
    
    public int getMarks() {
		return marks;
	}
}
