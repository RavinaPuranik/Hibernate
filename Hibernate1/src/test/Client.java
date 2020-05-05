package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
		
		Student st=new Student();
		st.setId(111);
		st.setName("abc");
		st.setEmail("abc@gmail.com");
		st.setMarks(500);
		// transient state
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		s.save(st);
		//persistant state
		
		s.beginTransaction().commit();
		//database state
		
		s.evict(st);
		//remove from persistant, then gc can collect
		
		
 
	}

}
