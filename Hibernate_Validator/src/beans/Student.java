package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;;


@Entity
@Table(name="student12", schema="hibernate")
public class Student {
	
	@Id
	@Column(name="sid")
	@Min(value=111,message="less that 111 !!")
	@Max(value=999,message="more than 999 !!")
    private int id;
	@Column(name="sname")
	@NotEmpty(message="name is empty")
    private String name;
	@NotEmpty(message="email is empty")
	@Email(message="wrong format")
	@Column(name="semail")
    private String email;
	@NotEmpty(message="address is empty")
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
