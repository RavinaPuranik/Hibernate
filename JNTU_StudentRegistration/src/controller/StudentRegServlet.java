package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

/**
 * Servlet implementation class StudentRegServlet
 */
@WebServlet("/reg")
public class StudentRegServlet extends HttpServlet {
	
	SessionFactory sf;
	
	@Override
		public void init(ServletConfig config) throws ServletException {
			
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		System.out.println("Session factory init");
		
		}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int marks=Integer.parseInt(req.getParameter("marks"));
		
		Student st=new Student(0,name,email,marks);
		Session s=sf.openSession();
		org.hibernate.Transaction t=s.beginTransaction();
		
		int pk=(Integer)s.save(st);
		t.commit();
		s.close();
		  resp.getWriter().println("reg success id= "+pk);
	
	}
	
   @Override
	public void destroy() {
		sf.close();
		super.destroy();
	}
	
	}


