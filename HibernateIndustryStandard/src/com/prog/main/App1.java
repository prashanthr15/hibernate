package com.prog.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prog.entity.Student2;
import com.prog.util.HibernateUtil;

public class App1 {

	

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction =null;
		 boolean flag=false;

		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				 transaction = session.beginTransaction();
			}
			
			if(transaction!=null) {
				Student2 st= new Student2();
				
				st.setId(1);
				st.setName("rahul");
				st.setAge(19);
				st.setCity("hyderabad");
				
				session.save(st);
				flag=true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		finally {
			
			if(flag) {
				//completely do it or else block to rollback
				transaction.commit();
				System.out.println(" data is saved in db");
				
			}
			else {
				//rollback means undo
				transaction.rollback();
				System.out.println("not able to store data in db");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeFactorySession();
			
		}
	}
}
