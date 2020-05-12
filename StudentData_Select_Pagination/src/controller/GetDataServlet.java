package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/select")
public class GetDataServlet extends HttpServlet {
	SessionFactory sf;
	
	@Override
	public void init() throws ServletException {
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session s=sf.openSession();
		PrintWriter out=resp.getWriter();
		int fr=Integer.parseInt(req.getParameter("fr"));
		int mr=Integer.parseInt(req.getParameter("mr"));
		//using query----------------------
//		Query q=s.createQuery("from Student");
//		q.setFirstResult(fr);
//		q.setMaxResults(mr);
//		List<Student> list=q.list();
		
		//using criteria-----------------
		Criteria cr=s.createCriteria(Student.class);
		cr.setFirstResult(fr);
		cr.setMaxResults(mr);
		List<Student> list=cr.list();
		
		for(Student st:list)
		{
			out.println("id: "+st.getId()+"\tname: "+st.getName()+"\temail: "+st.getEmail()+"\tmarks: "+st.getMarks());
		}
		s.close();
	}
	
	@Override
	public void destroy() {
		sf.close();
		
	}

}
