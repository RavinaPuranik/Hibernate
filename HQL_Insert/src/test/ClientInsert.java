package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class ClientInsert {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		OldStudent os1=new OldStudent(111, "abc", "a@email.com", "hyd");
		OldStudent os2=new OldStudent(222, "lmn", "l@email.com", "idr");
		OldStudent os3=new OldStudent(333, "xyz", "x@email.com", "mum");
		
		s.save(os1);
		s.save(os2);
		s.save(os3);
		t.commit();
		s.close();
		sf.close();

	}

}
