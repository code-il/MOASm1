package com.example.MOASm1.controller;

import com.example.MOASm1.entity.empclass;
import com.example.MOASm1.service.empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeecontroller {
    @Autowired
    empservice ems;
    @GetMapping("/employee")
    private List getall(){
        return this.ems.getall();
    }

    @GetMapping("/employee/{id}")
    public empclass getbyid(int id){
        return this.ems.getbyid(id);
    }

    @PostMapping("/employee")
    private ResponseEntity create(@RequestBody empclass emc2){
        try{
            this.ems.saveorupdate(emc2);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("CREATED ID:"+emc2.getId(),HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{id}")
    private ResponseEntity delete(@PathVariable ("id") int id){
        try{
            this.ems.delete(id);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("DELETED ID:"+id,HttpStatus.OK);
    }
}
