package com.jay.springboot.learnjpaandhibernate.course;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



import com.jay.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

// We use CommandLineRunner to do things as soon as the application starts
// We want to insert some data the startup so we use this commandlinerunner class to do it
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
	//@Autowired
	//private CourseJpaRepository rep;
	
	@Autowired
	private CourseSpringDataJpaRepository rep;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// save method is provided by spring data jpa to insert data into the db table
		rep.save(new Course(1, "Parallel Computing", "Dong Dai"));
		rep.save(new Course(2, "MAD", "Md Shehab"));
		rep.save(new Course(3, "Spring", "in28minutes"));
		
		rep.deleteById(1l);
		
		System.out.println(rep.findById(3l));
		
		System.out.println(rep.findAll());
		
	}

}
