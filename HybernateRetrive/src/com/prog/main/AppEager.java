package com.prog.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prog.entity.Student1;

public class AppEager {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.config.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		System.out.println("name os the class implementing session factory :" +sessionFactory.getClass().getName());
		
		
		Student1 st = session.get(Student1.class, 1);
		System.out.println("student id"+st.getId());
		System.out.println("student nsme"+st.getName());
		System.out.println("student age"+st.getAge());
		System.out.println("student city"+st.getCity());
		
		
		session.close();
		sessionFactory.close();
		
		
		
	}
}
