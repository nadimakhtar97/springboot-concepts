package com.nadim.springbootconcepts.controller;


import com.nadim.springbootconcepts.Request.CreateRequest;
import com.nadim.springbootconcepts.daos.Person;
import com.nadim.springbootconcepts.dbmanager.DBoperations;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {

    // @RequestMapping annotation
    // instead of @RequestMapping we can use @GetMapping
    //    @GetMapping(value="/getPersons")
    @RequestMapping(value="/getPersons",method = RequestMethod.GET)
    public List<Person> getAllPersons() throws SQLException {
        // calling DAO to get objects from DB
        return DBoperations.getAllPerson();
    }

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public void hi()
    {
        System.out.println("Hiiiiiiiii!!!!!!!");
    }


    @RequestMapping(value="/createTable",method = RequestMethod.POST)
    public void createTable(@RequestParam(value="name") String name) throws SQLException {
        DBoperations.createTable(name);
    }



    @RequestMapping(value="/insertPerson",method = RequestMethod.POST)
    // In @RequestBody we can use person object also But it is recommended to create
    // separate request object so that debugging process becomes easy.
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        DBoperations.insertPerson(request);
    }




}



