package com.rp.ManyToOne;

import javax.persistence.*;

@Entity  
@Table(name="emp107") 
public class Employee {
    
	@Id
	@GeneratedValue
	private int eid;
	private String name,email;
	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAdress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
