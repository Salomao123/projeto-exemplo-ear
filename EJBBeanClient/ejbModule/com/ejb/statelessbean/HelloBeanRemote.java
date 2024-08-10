package com.ejb.statelessbean;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
	
	public String sayHello();

}
