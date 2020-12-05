package com.xaltius.be.handler;

import com.xaltius.be.exception.IncorrectAgeException;
import com.xaltius.be.model.Person;
import com.xaltius.be.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.springframework.web.servlet.function.ServerResponse.*;

@Component
public class PersonHandler {

    private final PersonService personService;

    @Autowired
    public PersonHandler(PersonService personService) {
        this.personService = personService;
    }

    public ServerResponse handleGetPersonColor(ServerRequest serverRequest){
        try {
            return ok().body(personService.findPersonColorByAge(serverRequest.body(Person.class)));
        } catch (IncorrectAgeException e) {
            e.printStackTrace();
            return badRequest().body(e.getMessage());
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            return status(500).body(e.getMessage());
        }
    }
}
