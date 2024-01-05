package uk.co.huntersix.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.huntersix.spring.rest.exception.PersonBadRequestException;
import uk.co.huntersix.spring.rest.exception.PersonNotFoundException;
import uk.co.huntersix.spring.rest.model.Person;
import uk.co.huntersix.spring.rest.referencedata.PersonDataService;

import java.util.List;

@RestController
public class PersonController {
    private PersonDataService personDataService;

    public PersonController(@Autowired PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping("/person/{lastName}/{firstName}")
    public Person person(@PathVariable(value="lastName") String lastName,
                         @PathVariable(value="firstName") String firstName) {

        Person person = personDataService.findPerson(lastName,firstName);
        if(person.getId() ==null && person.getLastName().equals(null) && person.getFirstName().equals(null)){
           throw new PersonNotFoundException("empty person returns");
        }
        return person;
    }

    @GetMapping("/person/{lastName}")
    public List<Person> findAllPersonsBySurname(@PathVariable(value="lastName") String lastName) {
        List<Person> persons = personDataService.findPersonsBySurname(lastName);
        if(persons.isEmpty()){
            throw new PersonNotFoundException("no result found");
        }
        return persons;
    }

    @PostMapping("/person")
    public ResponseEntity<List<Person>> addPerson(@RequestBody Person person) {
        List<Person> persons = personDataService.addPerson(person);
        if(person.isPersonExist(person,persons)){
            throw new PersonBadRequestException("person already exist");
        }

        return new ResponseEntity<>(persons, HttpStatus.CREATED);
    }
}