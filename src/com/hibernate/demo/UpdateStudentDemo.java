package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			
			//Update Code
			//first get student's id (PK)
			int studentId = 3;
			
			//new session and begin transaction
			//session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve based on PK
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get complete " +myStudent);
			
			//set new data
			System.out.println("Updating data");
			myStudent.setFname("Davey");
			
			//set new query data
			session.createQuery("update Student set email='@australia.com'").executeUpdate();
			
			//Commit 
			session.getTransaction().commit();
			
			
			//update email for all students
			//session = factory.getCurrentSession();
			//session.beginTransaction();
			
			//session.createQuery("update Student set email='@aussies.com'").executeUpdate();
			
			//Commit 
			//session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
