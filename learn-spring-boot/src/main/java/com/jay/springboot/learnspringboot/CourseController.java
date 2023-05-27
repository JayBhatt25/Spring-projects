package com.jay.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.springboot.learnspringboot.Models.Course;



@RestController
public class CourseController {
	
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		
		return Arrays.asList(
				new Course(1, "Parallel Computing", "Dong Dai"),
				new Course(2, "Mobile Application Development", "Md Shehab"),
				new Course(3, "Learn Springboot", "Ranga")
				);
	}
	
}
