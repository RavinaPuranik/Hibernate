package beans;

public class Student {
    private int id;
    private String name,email,address;
    
    
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
    
    
    public String getAddress() {
		return address;
	}
    
    public String getEmail() {
		return email;
	}
    
    public void setAddress(String address) {
		this.address = address;
	}
}
