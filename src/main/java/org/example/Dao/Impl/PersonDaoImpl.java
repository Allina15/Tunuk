package org.example.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.Config.App;
import org.example.Dao.PersonDao;
import org.example.Model.Person;

public class PersonDaoImpl implements PersonDao {
    private final EntityManagerFactory entityManagerFactory = App.entityManagerFactory();
    @Override
    public String save(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "save person";
    }

    @Override
    public Person getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person;
    }

    @Override
    public Person updateByEmail(String email, Person newPerson) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Person person =entityManager.createQuery("select p from Person p where p.email=:email",Person.class)
                        .setParameter("email",email).getSingleResult();
        if (person!=null) {
            person.setFullName(newPerson.getFullName());
            person.setAge(newPerson.getAge());
            person.setEmail(newPerson.getEmail());

            entityManager.getTransaction().commit();
            entityManager.close();
            return person;
        }
        entityManager.getTransaction().rollback();
        return newPerson;
    }

    @Override
    public String deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(getById(id));
        entityManager.getTransaction().commit();
        entityManager.close();
        return "person removed";
    }
}
