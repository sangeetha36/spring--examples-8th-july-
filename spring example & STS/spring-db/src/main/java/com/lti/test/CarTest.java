package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.component.CarPart;
import com.lti.training.component.CarPartsInventory;

public class CarTest {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CarPartsInventory part=(CarPartsInventory)context.getBean("carPartsImpl4");
		
		
		//WE WILL ONLY MANAGE THE ENTITY CLASS OBJECTS OTHER ALL OBJECTS WILL BE CREATED BY THE SPRING
		CarPart c = new CarPart();
		c.setPartNo(114);
		c.setCarModel("RR 100x");
		c.setPartName("Gear");
		c.setQuantity(200);
		
		
		part.addNewPart(c);
	}
	
	@Test
	public void testFetch() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CarPartsInventory part=(CarPartsInventory)context.getBean("carPartsImpl3");
		
	
		for(CarPart p : part.getAvailableParts()){
			System.out.println("PartNo = "+p.getPartNo());
			System.out.println("Name = "+p.getPartName());
			System.out.println("CarModel = "+p.getCarModel());
			System.out.println("Quantity = "+p.getQuantity());	
		}}

}
