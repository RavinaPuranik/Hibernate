package com.rp.ManyToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course101")
public class Course {
   @Id
   @GeneratedValue
	private int cid;
	private String cname;
	private int fee;
	@ManyToMany(mappedBy = "courses")
	private Set<Faculty> faculties;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Set<Faculty> getFaculties() {
		return faculties;
	}
	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}
	
	
	
}