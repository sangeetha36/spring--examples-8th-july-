package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.component.Login;
import com.lti.training.component.LoginDetials;


public class Logintest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
     LoginDetials login=(LoginDetials)context.getBean("newLogin");
     
     Login l=new Login();
     l.setAcNo(180);
     l.setName("surya");
     l.setBalance(400);
     l.setAccType("current");
     login.addNew(l);
	}

	
	@Test
	public void testFetch() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
	     LoginDetials login=(LoginDetials)context.getBean("newLogin");
	     
	     for(Login l : login.getDetials()) {
	    	 System.out.println(l);
	     }
	}
}
