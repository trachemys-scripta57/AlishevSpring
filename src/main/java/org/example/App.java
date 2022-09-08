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

//            Person person = session.get(Person.class, 2);
//            //изменяем имя 2го пользователя
//            person.setName("new Lubomir");
            //удаляем 2го пользователя из таблицы
//            session.delete(person);

            //добавляем нового пользователя в таблицу
            Person person = new Person("Gavrila", 32);
            session.save(person);

            session.getTransaction().commit();

            System.out.println(person.getId());
            System.out.println(person.getName());
        } finally {
            sessionFactory.close();
        }
    }
}
