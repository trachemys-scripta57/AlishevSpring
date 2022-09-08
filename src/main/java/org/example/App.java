package org.example;

import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

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

            //выводим все данные из таблицы
//            List<Person> people = session.createQuery("FROM Person").getResultList();
            //получаем тех, кому больше 19 лет
//            List<Person> people = session.createQuery("FROM Person where age > 19").getResultList();
            //получаем тех, чьё имя начинается с буквы Т
//            List<Person> people = session.createQuery("FROM Person where name LIKE 'T%'").getResultList();
            //получаем тех, чьё имя содержит букву l
//            List<Person> people = session.createQuery("FROM Person where name LIKE '%l%'").getResultList();
            //изменить имена людей старше 18 лет на test
//            session.createQuery("update Person set name = 'test' where age > 18 ").
//                executeUpdate();
            //удалить из таблицы людей старше 20 лет
            session.createQuery("delete from Person where age > 20 ").
                    executeUpdate();

//            for (Person person : people)
//                System.out.println(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
