package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Admin;
import beans.Employee;
import beans.HEmployee;
import beans.SEmployee;


public class Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		SEmployee se=new SEmployee(111,"a","a@email.com",5000,"java");
		HEmployee he=new HEmployee(222,"b","b@email.com",8000,9);
		Admin a=new Admin(333,"c","c@email.com",10000,"HYD");
		s.save(se);
		s.save(he);
		s.save(a);
		t.commit();
		s.close();
		sf.close();

	}

}
