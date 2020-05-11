package test;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

//save data

public class SaveClient {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Student st=new Student();
		st.setId(111);
		st.setName("");
		st.setEmail("x");
		st.setAddress("");
		
		ValidatorFactory vf=Validation.buildDefaultValidatorFactory();
		Validator v=vf.getValidator();
		
		Set<ConstraintViolation<Student>> seterror=v.validate(st);
		
		
		if(!seterror.isEmpty()) {
		for(ConstraintViolation<Student> error:seterror) 
			System.out.println("Field: "+error.getPropertyPath()+"Message: "+error.getMessage());
		}
		else {
			int pk=(Integer)s.save(st);
			System.out.println(pk);
			
			t.commit();//query executed here
			s.close();
			sf.close();
			
			System.out.println("data inserted");
		}
		
		
		
		
		
		
 
	}

}
