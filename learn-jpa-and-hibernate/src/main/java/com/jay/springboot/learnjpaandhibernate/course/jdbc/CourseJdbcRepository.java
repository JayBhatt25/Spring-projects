package com.jay.springboot.learnjpaandhibernate.course.jdbc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jay.springboot.learnjpaandhibernate.course.Course;

// class to interact/fire queries to the database using spring jdbc
@Repository
public class CourseJdbcRepository {
	
	// We need an instance of JdbcTemplate to fire queries at the database. 
	// This dependency is autowired for us by spring using @Autowired
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
				insert into course(id,name,instructor)
				values(?,?,?);	
			""";
	
	private static String DELETE_QUERY = 
			"""
				Delete from course where id=?	
			""";
	
	private static String SELECT_QUERY = 
			"""
				Select * from course where id=?	
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getInstructor());
	}
	
	public void delete(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		// BeanPropertyRowMapper<>(Course.class) casts result to a course object given the variable names are matching in both
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
