package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Vasiliy", 22);
            Person person1 = new Person("Lubomir", 34);
            Person person2 = new Person("Klaus", 47);

            session.save(person);
            session.save(person1);
            session.save(person2);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
