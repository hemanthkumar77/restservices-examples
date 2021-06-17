package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.service.Business;

import rx.Observable;
import rx.Single;

@RestController
@RequestMapping("/api")
public class controller
{
	@Autowired
	private Business BU;

	@GetMapping(value="/call/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Single<Object> getparallelcall(@PathVariable("id") String id)
	{
		return (Single<Object>) BU.twoapicallparallele(id);
	}
}
