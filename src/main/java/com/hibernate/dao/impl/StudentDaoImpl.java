package com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.dao.StudentDao;
import com.hibernate.model.Student;


@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory session;

	public void add(Student student) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(student);
	}

	public void edit(Student student) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(student);
	}

	public void delete(int studentId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getStudent(studentId));
	}

	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return (Student)session.getCurrentSession().get(Student.class, studentId);
	}

	public List getAllStudent() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from student").list();
	}

}
