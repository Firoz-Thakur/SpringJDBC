package com.spring.jdbc;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		//
	//	JdbcTemplate template =  (JdbcTemplate) context.getBean("jdbcTemplate");
			
		// insert queuery
//		String query =  "insert into student(id,name,city) values(?,?,?)";
//		int result = template.update(query,3,"Raja ji","bali chowki ");
//		System.out.println("number of record inserted "+result);
//		
			
		
		// Inserting new data into the database
		StudentDaoImpl studentDao = context.getBean("studentDaoImpl",StudentDaoImpl.class);
		Student  student = new Student(new Random().nextInt(100000),"firoz","Shata Dhar , jai Shyati Nag ji ");
		int result = studentDao.insert(student);
		System.out.println("number of record inserted "+result);
		
//		
		// Updating the data in the data base with old id;
		
//		Student  student = new Student(3434,"Kumar","Kormangala East");
//		int result = studentDao.change(student);
//		System.out.println("number of record inserted "+result);
//	
		
		// Deletion of any particular key 
//		int result = studentDao.remove(3);
//		System.out.println("number of record inserted "+result);
//			
//		
		// get student row from the data base
//		Student student2 = studentDao.getStudent(222);
//		System.out.println(student2);
//		
		
		//Get all students row from the database;
		
		List<Student> studentList = studentDao.getStudents();
		System.out.println(studentList);
		
	}
}
