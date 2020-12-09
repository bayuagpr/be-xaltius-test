package com.xaltius.be.service;

import com.xaltius.be.exception.IncorrectAgeException;
import com.xaltius.be.exception.IncorrectNameException;
import com.xaltius.be.model.Colors;
import com.xaltius.be.model.Person;
import com.xaltius.be.model.PersonColor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PersonServiceImpl implements PersonService{

    @Override
    public PersonColor findPersonColorByAge(Person person) throws IncorrectAgeException, IncorrectNameException {
        return  PersonColor.builder()
                .name(checkNameValidity(person.getName()))
                .age(person.getAge())
                .colors(getColorByAge(person.getAge()))
                .build();
    }

    private String getColorByAge(Integer age) throws IncorrectAgeException {
        if(age == null){
            throw new NullPointerException("Age is required to be filled");
        }
        if(age>=1){
            if(age<=20){
                return Colors.LIGHTBLUE.getHexCode();
            } else if(age <= 50){
                return Colors.LIGHTRED.getHexCode();
            }else{
                return Colors.GREY.getHexCode();
            }
        }
        throw new IncorrectAgeException("Sorry, "+age+" years old doesn't meet requirement for generating. Minimum age is 1 years old.");
    }

    private String checkNameValidity(String name) throws IncorrectNameException {
        String regexCheckHasNumber = "(.)*(\\d)(.)*";
        Pattern patternHasNumber = Pattern.compile(regexCheckHasNumber);

        String regexCheckHasSymbol = "^[a-zA-Z0-9 ]*$";
        Pattern patternHasSymbol = Pattern.compile(regexCheckHasSymbol);

        if(name.length()==0){
            throw new IncorrectNameException("Name is required to be filled");
        }

        if(patternHasNumber.matcher(name).matches()){
            throw new IncorrectNameException("Name cannot contain number");
        }

        if(!patternHasSymbol.matcher(name).matches()){
            throw new IncorrectNameException("Name cannot contain symbol");
        }

        return name;
    }
}
