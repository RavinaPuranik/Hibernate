package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Employee;

public class HQL_SelectAll_Client {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		
		String hql="from Employee";
		Query q=s.createQuery(hql);
		List<Employee> list=q.list();
		for(Employee e:list) {
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getEmail());
		System.out.println(e.getSalary());
		System.out.println("-----------------");
		}
		

	}

}
