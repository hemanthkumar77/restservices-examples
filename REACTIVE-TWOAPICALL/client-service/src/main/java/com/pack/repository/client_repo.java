package com.pack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.profile;
@Repository
public interface client_repo extends CrudRepository<profile,String> 
{

}
