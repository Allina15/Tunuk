package org.example.Service.Impl;

import org.example.Dao.Impl.PersonDaoImpl;
import org.example.Dao.PersonDao;
import org.example.Model.Person;
import org.example.Service.PersonService;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();
    @Override
    public String save(Person person) {
        return personDao.save(person);
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public Person updateByEmail(String email, Person newPerson) {
        return personDao.updateByEmail(email,newPerson);
    }

    @Override
    public String deleteById(Long id) {
        return personDao.deleteById(id);
    }
}
