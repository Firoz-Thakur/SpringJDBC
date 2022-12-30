package com.spring.jdbc;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan("com.spring.jdbc") // we have to specify for which class we want  @component to make the object by its own
public class JdbcConfig {

	
	@Bean(name ={"ds"})
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("password");	
		System.out.println("z");
		return ds;
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate()
	{
	   JdbcTemplate jdbcTemplate = new JdbcTemplate();
		System.out.println("y");
	   jdbcTemplate.setDataSource(getDataSource());
	   return jdbcTemplate;
	}
	
	// Here we are creating the Object of studentDaoImpl and we are injecting the jdbcTemplate to it.
	
	// same we can achieve with the autowire.
// how ??
	// 1 -> we will create the object with the help of @component in StudentDaoImp
	// 2.-> we will use the autowire annotation in its property ( i.e object of JdbcTemplate)
	
//	@Bean(name = {"studentDaoImpl"})
//	public StudentDao getStudnetDao()
//	{
//		StudentDaoImpl studentDaoImpl =  new StudentDaoImpl();
//		studentDaoImpl.setJdbcTemplate(getTemplate());
//		System.out.println("x");
//		return studentDaoImpl;
//	}
	
}
