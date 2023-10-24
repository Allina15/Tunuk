package org.example;

import org.example.Model.Person;
import org.example.Service.Impl.PersonServiceImpl;
import org.example.Service.PersonService;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        System.out.println(personService.save(new Person("Alina", 20, "a@gmail.com")));
        System.out.println(personService.getById(1L));
        System.out.println(personService.updateByEmail("a@gmail.com",new Person("Tunuk",17,"dsfv")));
        System.out.println(personService.deleteById(1L));
    }
}
