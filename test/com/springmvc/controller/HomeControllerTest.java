package com.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:WebContent/WEB-INF/registration-servlet.xml","file:WebContent/WEB-INF/dataSource.xml"})
//@ContextConfiguration(locations={"classpath*:/WEB-INF/registration-servlet.xml","classpath*:/WEB-INF/dataSource.xml"})
//@ContextConfiguration("/WEB-INF/registration-servlet.xml")
public class HomeControllerTest{
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		mockMvc= MockMvcBuilders.webAppContextSetup(this.context).build();
		
	}	
	
	@Test
	public void testDisplayHomePage() throws Exception{
		
		 mockMvc.perform(
		            get("/"))
		           .andDo(MockMvcResultHandlers.print()) 
		            .andExpect(status().isOk())
		            .andExpect(view().name("home"));
		
		//mockMvc.perform(get("/")).andExpect(content().string(""));
		//andExpect(MockMvcResultMatchers.model().attributeExists("user"))
		
	}
}















