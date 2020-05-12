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
		//Session s2=sf.openSession();
		
		Student st=(Student)s.get(Student.class, 12);
		
		System.out.println(st.getId());
		System.out.println(st.getName());
		System.out.println(st.getMarks());
		System.out.println(st.getEmail());
		
Student st2=(Student)s.get(Student.class, 12);
		
		System.out.println(st2.getId());
		System.out.println(st2.getName());
		System.out.println(st2.getMarks());
		System.out.println(st2.getEmail());
		
		s.close();
		sf.close();

	}

}
