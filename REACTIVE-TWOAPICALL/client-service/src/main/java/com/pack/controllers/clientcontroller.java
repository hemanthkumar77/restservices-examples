package com.pack.controllers;


import java.util.function.Supplier;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.accountdetails;
import com.pack.entity.profile;
import com.pack.service.Business;

import rx.Single;

@RequestMapping("/client")
@RestController
public class clientcontroller
{
  
	@Autowired
	private Business bu;
	
	@GetMapping(value="/profile/{id}",produces=MediaType.APPLICATION_JSON)
	public 	Single<profile> profile_info(@PathVariable("id") String id)
	{
		profile object=bu.getprofileinfo(id).get();
	    return Single.just(object);
	}
	
	@GetMapping(value="/account/{id}",produces=MediaType.APPLICATION_JSON)
	public Single<accountdetails> accountinfo(@PathVariable ("id") String id)
	{
		accountdetails acc=bu.getaccountinfo(id).get();
		return Single.just(acc);
	}
}
