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
@Table(name="fac101")
public class Faculty {
	@Id
	@GeneratedValue
	private int fid;
	private String fname;
	private int yearex;
	@ManyToMany
	@JoinTable(
			  name = "fc", 
			  joinColumns = @JoinColumn(name = "fid"), 
			  inverseJoinColumns = @JoinColumn(name = "cid"))
	private Set<Course> courses;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getYearex() {
		return yearex;
	}
	public void setYearex(int yearex) {
		this.yearex = yearex;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}