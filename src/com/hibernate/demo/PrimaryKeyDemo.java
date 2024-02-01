package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					//creating multiple objects
					System.out.println("creating multiple objects");
					Student tempStudent1 = new Student("ricky","ponting","ricky@australia.com");
					Student tempStudent2 = new Student("steve","smith","smith@australia.com");
					Student tempStudent3 = new Student("david","warner","warner@australia.com");
					
					//begin transaction
					session.beginTransaction();
					
					//save the object
					System.out.println("Saving the objects");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit
					session.getTransaction().commit();
					
					System.out.println("Done");
				}
				finally
				{
					factory.close();
				}


	}

}
