package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class getClient {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		
		Student st=(Student)s.get(Student.class, 222);
				
		s.close();
		sf.close();
		
		System.out.println(st.getId());
		System.out.println(st.getName());
		System.out.println(st.getAddress());
		System.out.println(st.getEmail());

	}

}
