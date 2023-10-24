package org.example.Dao;

import org.example.Model.Person;

public interface PersonDao {
    String save(Person person);
    Person getById(Long id);
    Person updateByEmail(String email, Person newPerson);
    String deleteById(Long id);
}
