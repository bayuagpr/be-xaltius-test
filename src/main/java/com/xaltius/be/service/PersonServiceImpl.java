package com.xaltius.be.service;

import com.xaltius.be.exception.IncorrectAgeException;
import com.xaltius.be.model.Colors;
import com.xaltius.be.model.Person;
import com.xaltius.be.model.PersonResponse;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Override
    public PersonResponse findPersonColorByAge(Person person) throws IncorrectAgeException {
        return  PersonResponse.builder()
                .name(person.getName())
                .age(person.getAge())
                .colors(getColorByAge(person.getAge()))
                .build();
    }

    private String getColorByAge(Integer age) throws IncorrectAgeException {
        if(age>=1){
            if(age<=20){
                return Colors.LIGHTBLUE.getHexCode();
            } else if(age <= 50){
                return Colors.LIGHTRED.getHexCode();
            }else{
                return Colors.GREY.getHexCode();
            }
        }
        throw new IncorrectAgeException("Age "+age+" doesn't meet requirement");
    }
}
