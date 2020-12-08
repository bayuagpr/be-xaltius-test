package com.xaltius.be.service;

import com.xaltius.be.exception.IncorrectAgeException;
import com.xaltius.be.exception.IncorrectNameException;
import com.xaltius.be.model.Person;
import com.xaltius.be.model.PersonColor;

public interface PersonService {
    PersonColor findPersonColorByAge(Person person) throws IncorrectAgeException, IncorrectNameException;
}
