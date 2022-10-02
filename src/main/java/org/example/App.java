package org.example;

import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("TestPerson2", 24);
            Passport passport = new Passport(7654321);

            person.setPassport(passport); //связь установлена с двух сторон

            session.save(person); //

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
