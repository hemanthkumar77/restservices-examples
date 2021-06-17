package com.pack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.business.business;
import com.pack.controller.cntroller;
import com.pack.model.studentdto;

@WebMvcTest(cntroller.class) 
@RunWith(SpringRunner.class)
public class controllertest 
{
       @Autowired
	   private cntroller cnt;
	   
       @Autowired
       private MockMvc mock;
	   
	   @MockBean
	   private business bu;
	   
	   
	   @Test
	   public void getmethod() throws Exception
	   {
		studentdto obj=new studentdto();
		     obj.setId(200);
		     obj.setFirstname("maverick");
		     obj.setLastname("wick");
		     obj.setAge(20);
		     obj.setGpa(3.77);
		     obj.setDeptname("java");
		   // making the mock in service layer for get call of the student through id
		  when(bu.get_id(anyInt())).thenReturn(obj);
		  
		 ((ResultActions) mock.perform(get("/student_api/student/101"))).andDo(print())
		  .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(200))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("maverick"))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("wick"))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.deptname").value("java"))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.gpa").value(3.77))
		  .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(20))
		  .andExpect(status().isOk());
	   }
       
	   @Test
	   public void postmethod() throws JsonProcessingException, Exception
	   {
		   studentdto obj=new studentdto();
		     obj.setId(200);
		     obj.setFirstname("maverick");
		     obj.setLastname("wick"); 
		     obj.setAge(20);
		     obj.setGpa(3.77);
		     obj.setDeptname("java");
		     
		     studentdto ob1=new studentdto();
		     ob1.setId(190);
		     ob1.setFirstname("JHON");
		     ob1.setLastname("wiLLISON"); 
		     ob1.setAge(19);
		     ob1.setGpa(3.88);
		     ob1.setDeptname("GOLANG");
		     
		     when(bu.save_records((studentdto) any(studentdto.class))).thenReturn(ob1);
		       
		     mock.perform(post("/student_api/save").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(obj)))
				.andExpect(status().isCreated()).andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(190))
				  .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("JHON"))
				  .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("wiLLISON"))
				  .andExpect(MockMvcResultMatchers.jsonPath("$.deptname").value("GOLANG"))
				  .andExpect(MockMvcResultMatchers.jsonPath("$.gpa").value(3.88))
				  .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(19));
	   }
       
}
