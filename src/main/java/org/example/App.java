package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Работаем с БД через Hibernate
 */
public class App {
    public static void main(String[] args) {
        //передаём класс нашей сущности Person.class (из hibernate.properties)
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        //Получаем SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        // из полученной SessionFactory получаем поле session для работы с Hibernate

        try {
            //начинаем транзакцию
            session.beginTransaction();
            //получаем сущность Person с id=1
            Person person = session.get(Person.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());

            //закрываем транзакцию
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
            //закрываем SessionFactory. Обычно в блоке finally
        }
    }
}
