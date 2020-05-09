package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;

import beans.Employee;


public class SelectAll_Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		Criteria c=s.createCriteria(Employee.class);
		List<Employee> list=c.list();
		for(Employee e:list)
			System.out.println(e.getName());
		s.close();
		sf.close();

	}

}
