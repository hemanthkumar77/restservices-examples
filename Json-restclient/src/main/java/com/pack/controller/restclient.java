package com.pack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pack.model.studentdto;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.*;


import org.springframework.*;
public class restclient
{
	private static final String get_all="http://localhost:9001/student_api/students/all";
	private static final String get_id="http://localhost:9001/student_api/student/";
	private static final String insert_record="http://localhost:9001/student_api/save";
	private static final String delete_record="http://localhost:9001/student_api/delete/";
	private static  RestTemplate temp=new RestTemplate();

	public static void main(String args[])
  {      // exchange method
      	//  getall();
      	  get_id();
      	  //insertrecord();
      	  
      	 // forpostentity,delete,forgetentity
      	 // deleterecords();
      	  getallmethods();
      	  getidmethods();
      	  savemethod();
  }
  
  public static void getall()
  {
	 
	 HttpHeaders object=new HttpHeaders();
	  object.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	
	 HttpEntity<String>val=new HttpEntity(object);
	 
	 ResponseEntity<List> obj=temp.exchange(get_all,HttpMethod.GET,val,List.class);
	 List use=obj.getBody();
	 use.forEach(System.out::println);
	 
  }
   
  public static void get_id()
  {
		 HttpHeaders object=new HttpHeaders();
		 object.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		 int id=101;
		 HttpEntity<String>val=new HttpEntity(object);
	     ResponseEntity<studentdto> obj=temp.exchange(get_id+id,HttpMethod.GET,val,studentdto.class); 
	     studentdto value=obj.getBody();
	     System.out.print(value);
  }
  
  public static void insertrecord()
  {
	  HttpHeaders object=new HttpHeaders();
	  object.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	  studentdto obj=new studentdto();
	  obj.setId(106);
	  obj.setFirstname("will");
	  obj.setLastname("smit");
	  obj.setDeptname("accounts");
	  obj.setGpa(8.88);
	  obj.setAge(20);
	  // in this constructor first enter the the entity object and the setContentType
	  HttpEntity<Object> va=new HttpEntity(obj,object);
// we are here using the String.class because we are going to add the record to the third party client in other api so sending the String application json
	  ResponseEntity<String> met=temp.exchange(insert_record,HttpMethod.POST,va,String.class);
	  // delete method and also the update also the same in exchange
	  //ResponseEntity<String> me=temp.exchange(delete_record,HttpMethod.DELETE,va,String.class);  
  }
  
  public static void deleterecords()
  {
	  temp.delete(delete_record+106);
  }
  public static void getallmethods()
  {
	  ResponseEntity<List> value=temp.getForEntity(get_all,List.class);
	  List val=value.getBody();
	  val.forEach(System.out::println);
  }
  public static void getidmethods()
  {
	  ResponseEntity<studentdto> value=temp.getForEntity(get_id+101,studentdto.class);
	  studentdto obj=value.getBody();
	  System.out.print(obj);
  }
  
  public static void savemethod()
  {
	  studentdto obj=new studentdto();
	  obj.setId(106);
	  obj.setFirstname("will");
	  obj.setLastname("smit");
	  obj.setDeptname("accounts");
	  obj.setGpa(8.88);
	  obj.setAge(20);
	ResponseEntity<String> value=temp.postForEntity(insert_record,obj,String.class);  
  }
  
}
