package com.pack.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pack.model.accountdetails;
import com.pack.model.profile;

import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.functions.Func3;

@Service
public class Business
{
	private static final String getprofile="http://localhost:8080/client/profile/";
	private static final String getaccount="http://localhost:8080/client/account/";
	private static  RestTemplate temp=new RestTemplate();
	
	public Single<Object> twoapicallparallele(String id)
	{
		return Single.zip(getprofileinfo(id),getaccountinfo(id),(s1,s2)->Arrays.asList(s1,s2));
	}
	
	public Single<profile> getprofileinfo(String id)
	{
		 ResponseEntity<profile> value=temp.getForEntity(getprofile+id,profile.class);
		 return Single.just(value.getBody());	
	}
	
	public Single<accountdetails> getaccountinfo(String id)
	{
		 ResponseEntity<accountdetails> value=temp.getForEntity(getaccount+id,accountdetails.class);
		 return Single.just(value.getBody());	
	}
	
}
