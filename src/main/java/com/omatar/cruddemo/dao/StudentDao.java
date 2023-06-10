package com.omatar.cruddemo.dao;

import java.util.List;

import com.omatar.cruddemo.entity.Student;

public interface StudentDao {

	public void save(Student student);
	
	public void update(Student student);
	
	public void delete(int studentId);

	public Student findById(int id);

	public List<Student> findAll();

}
