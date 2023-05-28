package com.jay.springboot.learnjpaandhibernate.course.jpa;


import org.springframework.stereotype.Repository;

import com.jay.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional  // To execute queries using jpa, we need the repository to be transaction enabled
public class CourseJpaRepository {
	
	
	@PersistenceContext     // Same function as autowired but more specific for entity related stuff
	private EntityManager entityManager;
	
	public void insert(Course course) {
		// merge method is used to insert a row into the db table.
		// We just pass in the object and entity will take care of the mapping to the db table for us
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
}
