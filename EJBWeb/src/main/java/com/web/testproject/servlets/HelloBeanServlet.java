package com.web.testproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.statelessbean.HelloBeanRemote;

@WebServlet("/HelloBeanServlet")
public class HelloBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloBeanServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			InitialContext context = new InitialContext();
			HelloBeanRemote remoteBean = (HelloBeanRemote)
					context.lookup("java:global/EJBEar/EJBBean/HelloBean!com.ejb.statelessbean.HelloBeanRemote");
			
			String responseBean = remoteBean.sayHello();
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.print(responseBean);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
