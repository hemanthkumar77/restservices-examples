package com.pack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.accountdetails;
@Repository
public interface account extends CrudRepository<accountdetails,String>
{

}
