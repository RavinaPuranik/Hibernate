package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Employee;

public class HQL_Aggregate_Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		String hql="select avg(salary) from Employee";
		Query q=s.createQuery(hql);
		double avg=(Double)q.uniqueResult();
		
		System.out.println("Avg salary: "+avg);
		}
		

	}


