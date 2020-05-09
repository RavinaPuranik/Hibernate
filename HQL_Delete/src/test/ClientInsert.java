package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class ClientInsert {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		//Student st1=new Student(111, "abc", "a@email.com" );
		Student st2=new Student(333, "lmn", "l@email.com" );
		//s.save(st1);
		s.save(st2);
		t.commit();
		s.close();
		sf.close();

	}

}
