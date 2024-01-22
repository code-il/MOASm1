package com.example.MOASm1.service;

import com.example.MOASm1.entity.empclass;
import com.example.MOASm1.repository.emprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class empservice {
    @Autowired
    emprepo emr;

    public List getall(){
        List l1=new ArrayList<>();
        this.emr.findAll().forEach((empclass) ->{
            l1.add(empclass);
        } );
        return l1;
    }

    public empclass getbyid(int id){
        return this.emr.findById(id).get();
    }

    public void saveorupdate(empclass empc1){
         this.emr.save(empc1);
    }

    public void delete(int id){
        this.emr.deleteById(id);
    }
}
