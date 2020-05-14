package com.rp.OneToOne;

import javax.persistence.*;

@Entity  
@Table(name="emp220") 
public class Employee {
    
	@Id
	@GeneratedValue
	@PrimaryKeyJoinColumn
	private int eid;
	private String name,email;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
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
