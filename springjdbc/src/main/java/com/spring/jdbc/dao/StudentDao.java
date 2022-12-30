package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDao {
	
	
	public int insert(Student student);
	public int change(Student student);
	public int remove(int key);
	public Student getStudent(int id);
	List<Student> getStudents();
	
}
