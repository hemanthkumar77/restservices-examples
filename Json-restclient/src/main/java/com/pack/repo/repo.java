package com.pack.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pack.model.student;

@Repository
public interface repo extends CrudRepository<student,Integer>
{
 
}
