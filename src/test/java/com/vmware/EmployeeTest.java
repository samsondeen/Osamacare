package com.vmware;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeTest {

	private Employee employee;
	
	@BeforeMethod
	public void setUp(){
		System.out.println("before method test is create here");
		employee = new Employee(Pattern.compile("\\d{3}-\\d{2}-\\d{4}"));
	}

	
	@Test
	public void createEmployeeAndGetName() {
		//Employee employee = new Employee();
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}
	
	@Test
	public void addSocialSecurityNumber(){
		
		//Employee employee = new Employee();
		employee.setSocialSecurityNumber("123-45-6789");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
	}
	
	@Test
	public void addAnotherSocialSecurityNumber(){
		
		//Employee employee = new Employee();
		employee.setSocialSecurityNumber("123-45-6708");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6708");
	}
	
	/**
	 * Social Security number must be in social Security format
	 */
	@Test
	public void fix123457_SocialSecurityNumberMustBeACertainFormat(){
		
		String badSSN ="RamLikesThe49ers";
	//	Employee employee = new Employee();
		try{
			employee.setSocialSecurityNumber(badSSN);
			fail("This Line Should never been reach");
			
		}catch (IllegalArgumentException line){
			assertEquals(line.getMessage(), "RamLikesThe49ers is not a valid social security number");
		}
		
	}
}
