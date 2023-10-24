package org.example.Service;

import org.example.Model.Person;

public interface PersonService {
    String save(Person person);
    Person getById(Long id);
    Person updateByEmail(String email, Person newPerson);
    String deleteById(Long id);
}
