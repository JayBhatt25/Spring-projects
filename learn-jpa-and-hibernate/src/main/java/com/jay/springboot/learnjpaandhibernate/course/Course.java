package com.jay.springboot.learnjpaandhibernate.course;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course  {
	
	@Id
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="instructor")
	private String instructor;
	
	public Course() {
		
	}

	public Course(long id, String name, String instructor) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}

	
	

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + "]";
	}
	
	
	
}
