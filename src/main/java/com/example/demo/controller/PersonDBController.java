package com.example.demo.controller;


import com.example.demo.controller.repository.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonDBController {

    //Create
    @Autowired
    PersonRepository repository;

    @RequestMapping(value= "add_person_db",method = RequestMethod.POST)
    public String add(@RequestBody Person person){

        repository.save(person);
        return "person added to DB successfully";


    }

    //get

    @RequestMapping(value = "get_person_db", method = RequestMethod.GET)
    public List<Person> getAll(){
        return repository.findAll();

    }

    //Update

    @RequestMapping(value = "update_person_db",method = RequestMethod.PUT)
    public String update(@RequestParam String name,@RequestParam Integer id){
        Person person=repository.getById(id);
        person.setName("Krishna");
        repository.save(person);
        return "name updated in DB successfully";
    }

    //Delete

    @RequestMapping(value ="delete_person_db",method = RequestMethod.DELETE)
    public String delete(@RequestParam Integer id){
        repository.deleteById(id);
        return "person deleted in DB successfully";



    }
}
