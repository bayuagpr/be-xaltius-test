package com.xaltius.be.controller;

import com.xaltius.be.exception.IncorrectAgeException;
import com.xaltius.be.exception.IncorrectNameException;
import com.xaltius.be.model.Person;
import com.xaltius.be.model.PersonColor;
import com.xaltius.be.model.response.PersonColorResponse;
import com.xaltius.be.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/process/age")
    public PersonColorResponse handleGetPersonColor(@RequestBody Person person) throws IncorrectAgeException, IncorrectNameException {
        return PersonColorResponse.builder()
                .statusCode(200)
                .personColor(personService.findPersonColorByAge(person))
                .build();

    }
}
