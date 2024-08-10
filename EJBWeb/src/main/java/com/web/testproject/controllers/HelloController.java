package com.web.testproject.controllers;

import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejb.statelessbean.HelloBeanRemote;

@Path("/hello")
public class HelloController {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		try {
			InitialContext context = new InitialContext();
			HelloBeanRemote remoteBean = (HelloBeanRemote)
					context.lookup("java:global/EJBEar/EJBBean/HelloBean!com.ejb.statelessbean.HelloBeanRemote");
			
			return remoteBean.sayHello();
			
		} catch (NamingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
