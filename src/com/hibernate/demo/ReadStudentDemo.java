package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			//creating a object
			System.out.println("creating the object");
			Student tempStudent = new Student("pat","cummins","pat@australia.com");
			
			
			//begin transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("Saving the object");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit
			session.getTransaction().commit();
			
			//Read Code
			//first get student's id (PK)
			System.out.println("Student's PK "+tempStudent.getId());
			
			//new session and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve based on PK
			System.out.println("\nGetting student with id "+tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete " +myStudent);
			
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
