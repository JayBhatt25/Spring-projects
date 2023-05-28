package com.jay.springboot.learnjpaandhibernate.course;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.jay.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

// We use CommandLineRunner to do things as soon as the application starts
// We want to insert some data the startup so we use this commandlinerunner class to do it
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJpaRepository rep;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		rep.insert(new Course(1, "Parallel Computing", "Dong Dai"));
		rep.insert(new Course(2, "MAD", "Md Shehab"));
		rep.insert(new Course(3, "Spring", "in28minutes"));
		
		rep.deleteById(1);
		
		System.out.println(rep.findById(3));
	}

}
