package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mysql.cj.Query;
import com.spring.jdbc.entity.Student;

// component annotation will create the object of StudentDaoImp
@Component 
public class StudentDaoImpl implements StudentDao {

	
	// autowiere annotation will link ( inject the JDBCTEmplate object to here ) dependency injection
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query =  "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int change(Student student) {
		// TODO Auto-generated method stub
		String query = "update student set name=? ,city = ? where id=?"; // order should follow
		int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}

	public int remove(int key) {
		// TODO Auto-generated method stub
		String query = "delete from student where id = ?";
		int result = this.jdbcTemplate.update(query,key);
		return result;
	}

	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		return this.jdbcTemplate.queryForObject(query, rowMapper, id);	
		
		// we can always create annonymous class object here.
		
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		String query = "select * from student";
		return this.jdbcTemplate.query(query, new RowMapperImpl());	
	}

}
