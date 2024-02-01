package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//create session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//now use this session to save/retrieve objects
		try
		{
			
			
			//Delete Code
			//first get student's id (PK)
			//int studentId = 1;
			
			//new session and begin transaction
			//session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve based on PK
			//Student myStudent = session.get(Student.class, studentId);
			//System.out.println("Get complete " +myStudent);
			
			//Delete the student
			//System.out.println("Deleting student");
			//session.delete(myStudent);
			
			//Delete student using query
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//Commit 
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
