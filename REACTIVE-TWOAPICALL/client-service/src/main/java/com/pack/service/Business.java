package com.pack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.accountdetails;
import com.pack.entity.profile;
import com.pack.repository.account;
import com.pack.repository.client_repo;

import rx.Single;

@Service
public class Business 
{
	@Autowired
    private client_repo rep;
	
	@Autowired
	private account acc;

	public Optional<profile> getprofileinfo(String id) 
	{
			if(rep.existsById(id))
			{		
		    Optional<profile> pro=rep.findById(id);
			return  pro;}
			else
			{
	           return null;
			}
	}

	public Optional<accountdetails> getaccountinfo(String id) 
	{
		if(acc.existsById(id))
		{
			Optional<accountdetails>app=acc.findById(id);
			return app;
		}
		else
		{
			return null;
		}
	}
	
	
}
