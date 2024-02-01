package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			//begin transaction
			session.beginTransaction();
			
			//query the objects
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display objects
			displayStudents(theStudents);
			
			//query the objects for lname = 'ponting'
			theStudents = session.createQuery("from Student s where s.lname = 'ponting'").getResultList();
			
			//display objects
			System.out.println("\n\nStudents with last name as ponting");
			displayStudents(theStudents);
			
			//query the objects for lname = 'smith' OR fname = 'david'
			theStudents = session.createQuery("from Student s where s.lname = 'smith' OR s.fname = 'David'").getResultList();
			
			//display objects
			System.out.println("\n\nStudents with last name as smith OR first name as david");
			displayStudents(theStudents);
			
			//query the objects for LIKE predicate
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display objects
			System.out.println("\n\nStudents with email like gmail.com");
			displayStudents(theStudents);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}
