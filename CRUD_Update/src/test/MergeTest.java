package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class MergeTest {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		s.get(Student.class, 222);
		
		Student st=new Student();
		st.setId(222);
		st.setName("abc");
		st.setEmail("pqr@gmail.com");
		st.setAddress("hyd");
		
		s.merge(st);
		
		t.commit();//query executed here
		s.close();
		sf.close();
		
		System.out.println("data updated");

	}

}
