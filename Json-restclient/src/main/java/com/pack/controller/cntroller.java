package com.pack.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.business.business;
import com.pack.model.studentdto;

@RestController
@RequestMapping("/student_api")
public class cntroller 
{
   @Autowired
   private business bu;
	
   @RequestMapping("/student/{id}")
   @GetMapping
   @Produces(MediaType.APPLICATION_JSON)
   public ResponseEntity get_id(@PathVariable("id") int id)
   {
	  studentdto object= bu.get_id(id);
	  if(object!=null)
	  {
		  return ResponseEntity.status(200).body(object);
	  }
	  else
	  {
		  return ResponseEntity.status(200).body("NOT IN DB");
	  }
   }
	
   @RequestMapping("students/all")
   @GetMapping
   @Produces(MediaType.APPLICATION_JSON)
   public ResponseEntity get_all()
   {
	   List<studentdto> object= bu.student_all();
	   if(!object.isEmpty())
	   {
		   return ResponseEntity.status(200).body(object);
	   }
	   else
	   {
		   return ResponseEntity.status(200).body("no values DB");
	   }
   }
   
   @PostMapping
   @RequestMapping("/save")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public ResponseEntity save(@RequestBody studentdto dto)
   {
	   studentdto value=bu.save_records(dto);
	   return ResponseEntity.status(201).body(value);
   }
   
   @PutMapping
   @RequestMapping("/update")
   @Consumes(MediaType.APPLICATION_JSON)
   public String update(@RequestBody studentdto dto)
   {
	   String value=bu.update_student(dto);
	   return value;
   }
   
   @DeleteMapping
   @RequestMapping("/delete/{id}")
   public String delete(@PathVariable ("id") int id)
   {
	 String value=bu.delete(id);
	 return value;
   }
   
   @PostMapping
   @RequestMapping("/bulk_insert")
   @Consumes(MediaType.APPLICATION_JSON)
   public String bulk_insert(@RequestBody List<studentdto> dto)
   {
	   String value=bu.insert_bulk(dto);
	   return value;
   }
}
