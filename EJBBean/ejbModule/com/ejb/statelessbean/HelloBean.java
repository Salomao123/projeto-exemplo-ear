package com.ejb.statelessbean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(mappedName = "HelloBean")
@LocalBean
public class HelloBean implements HelloBeanRemote {

    public HelloBean() { }

	@Override
	public String sayHello() {
		return "hello world";
	}

}
