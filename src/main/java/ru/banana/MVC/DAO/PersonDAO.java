package ru.banana.MVC.DAO;

import org.springframework.stereotype.Component;
import ru.banana.MVC.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Гавриил"));
        people.add(new Person(++PEOPLE_COUNT, "Тарас"));
        people.add(new Person(++PEOPLE_COUNT, "Михайло"));
        people.add(new Person(++PEOPLE_COUNT, "Аннушка"));
    }

    public List<Person> index() {
        //возвращаем список people и потом через ThymLeaf отобразим в браузере
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id)
                .findAny().orElse(null);
/* находим человека по id и если такого нет, возвращаем null */
    }
}
//обычно общается с БД. Но для примера строим коллекцию