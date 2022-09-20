package ru.banana.MVC.DAO;

import org.springframework.stereotype.Component;
import ru.banana.MVC.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/SpringAlishevDB_1";
    private static final String USERNAME = "postgres";
    private static final String PASS = "root";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Person> index() {
        //возвращаем список people и потом через ThymeLeaf отобразим в браузере
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from person";
            ResultSet resultSet = statement.executeQuery(SQL);
            //executeQuery - не изменяет данные в БД

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id)
//                .findAny().orElse(null);
///* находим человека по id и если такого нет, возвращаем null */
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

        try {
            Statement statement = connection.createStatement();
            String SQL = "insert into person values(" + 1 + ", " + "'" + person.getName()
                    + "', " + person.getAge() + ", '" + person.getEmail() + "')";

            //INSERT INTO Person VALUES(1, 'Tom', 18, 'aaa@aa.ru')

            statement.executeUpdate(SQL);
            //executeUpdate -изменяет данные в БД

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
//        Person personToBeUpdated = show(id);
////получаем новые данные edit.html и выполняем замену
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
        //проходим по каждому человеку из списка, получаем его id
        //removeIf метод ArrayList
    }
}
//обычно общается с БД. Но для примера строим коллекцию