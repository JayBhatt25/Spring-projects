package com.jay.springboot.learnjpaandhibernate.course;

import java.io.Serializable;

public class Course implements Serializable {
	
	private long id;
	private String name, instructor;
	
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
