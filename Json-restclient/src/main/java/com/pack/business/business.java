package com.pack.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.model.student;
import com.pack.model.studentdto;
import com.pack.repo.repo;


@Service
public class business 
{
    @Autowired
	private repo re;
    @Autowired
    private studentdto dto;
    @Autowired
    private student stu;
    
    ObjectMapper data=new ObjectMapper();
    
    ModelMapper object=new ModelMapper();
    
    
    public studentdto get_id(int id)
    {
    	Optional<student>obj=re.findById(id);
        if(obj.isPresent())
        {
         object.map(obj.get(),dto);
         return dto;
        }
        else
        {
           return null;    	
        }
    }
    
    public List<studentdto> student_all()
    {
    	List<studentdto>va=new ArrayList();
    	
    	List<student> obj=(List<student>) re.findAll();
    	if(obj!=null)
    	{
    		for(student da:obj)
    		{
    	       va.add(object.map(da,studentdto.class));	
    		}
    		return va;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    public studentdto save_records(studentdto value)
    {
    
       if(!re.existsById(value.getId()))
       {
    	   object.map(value,stu);
    	 try {
			data.writeValue(new File("C:/Users/hemar/OneDrive/Desktop/JAVA-PROJECTS/Json-restclient/target/student.json/"), value);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 re.save(stu);
    	 return value;
       }
       else
       {
    	   return null;
       }
    }

	public String update_student(studentdto dto2) {
		if(re.existsById(dto2.getId()))
		{
			object.map(dto2,stu);
			re.save(stu);
			return "student_records_updated";
		}
		else
		{
			return "not found in DB";
		}
		
	}

	public String delete(int id)
	{
	     if(re.existsById(id))
	     {
	    	 re.deleteById(id);
	    	 return "deleted successfully";
	     }
	     else
	     {
	    	return "not found in the DB";
	     }
	}

	public String insert_bulk(List<studentdto> dto2)
	{
		List<student> va=new ArrayList();
		
		for(studentdto val:dto2)
		{
			if(!re.existsById(val.getId()))
			{
			va.add(object.map(val,student.class));
			}
		}
		
		re.saveAll(va);
		return "bulk_insert_successfully";
	}
    
}
