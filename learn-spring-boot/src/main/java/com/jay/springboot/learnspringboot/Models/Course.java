package com.jay.springboot.learnspringboot.Models;

import java.io.Serializable;

public class Course implements Serializable {
	
	int id;
	String name, instructor;
	
	public Course(int id, String name, String instructor) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + "]";
	}
	
	
	
}
