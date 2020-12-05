package com.xaltius.be.service;

import com.xaltius.be.exception.IncorrectAgeException;
import com.xaltius.be.model.Person;
import com.xaltius.be.model.PersonResponse;

public interface PersonService {
    PersonResponse findPersonColorByAge(Person person) throws IncorrectAgeException;
}
