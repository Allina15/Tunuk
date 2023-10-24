package org.example.Config;

import jakarta.persistence.EntityManagerFactory;
import org.example.Model.Person;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static EntityManagerFactory entityManagerFactory(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/database");
        properties.setProperty(Environment.USER,"postgres");
        properties.setProperty(Environment.PASS,"1234");
        properties.setProperty(Environment.HBM2DDL_AUTO,"update");
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Person.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
