package com.springmvc.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.bean.User;

@RunWith(Parameterized.class)
public class RegistrationControllerTest {
	
	RegistrationController rc;
	
	String expected;
	User user;


	static BindingResult result = mock(BindingResult.class);
	
	static HttpServletRequest request = mock(HttpServletRequest.class);
	
	static MultipartFile image = mock(MultipartFile.class);
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(RegistrationControllerTest.class);
		rc= new RegistrationController();
		when(result.hasErrors()).thenReturn(false);
		
		
	}	
	
	public RegistrationControllerTest(User user, BindingResult result, MultipartFile image, HttpServletRequest request,String expected) {
		this.user=user;
		RegistrationControllerTest.result=result;
		RegistrationControllerTest.image=image;
		RegistrationControllerTest.request=request;
		this.expected =expected;
	}
	
	@Parameterized.Parameters
	public static Collection testData(){
		
		return Arrays.asList(new Object[][]{
			{new User("Tejaswi","venupalli","qwertyui","teja@gmail.com","female"),result,image,request,"Success"}
			
		});
		
	}
	
	@Test
	public void testRegisterUser(){
		
		Assert.assertEquals(expected, rc.registerUser(user, result, image, request));
	}

}
