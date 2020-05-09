package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class HQL_Dump_Data {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
	
		Query q=s.createQuery("insert into NewStudent(id,name,email,address) select id,name,email,address from OldStudent");
		System.out.println("no of rows dumbed from old to new table "+q.executeUpdate());
		t.commit();
		s.close();
		sf.close();


	}

}
