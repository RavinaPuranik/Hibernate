package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

//save data

public class PersistClient {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Student st=new Student();
		st.setId(222);
		st.setName("xyz");
		st.setEmail("x@mail.com");
		st.setAddress("hyd");
		
		s.persist(st);
		
		t.commit();//query executed here
		s.close();
		sf.close();
		
		System.out.println("data inserted");
		
		
		
		
 
	}

}
