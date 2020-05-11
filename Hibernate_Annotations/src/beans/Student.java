package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student12", schema="hibernate")
public class Student {
	
	@Id
	@Column(name="sid")
    private int id;
	@Column(name="sname")
    private String name;
	@Column(name="semail")
    private String email;
	@Column(name="saddress")
    private String address;
	@Transient
	private int marks;
    
    
    public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

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
