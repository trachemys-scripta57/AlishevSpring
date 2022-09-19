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

        people.add(new Person(++PEOPLE_COUNT, "Гавриил", 24, "gavr@ya.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Тарас", 52, "taras@rambler.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Михайло", 18, "mikha@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Аннушка", 34, "anna@yahoo.com"));
    }

    public List<Person> index() {
        //возвращаем список people и потом через ThymeLeaf отобразим в браузере
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id)
                .findAny().orElse(null);
/* находим человека по id и если такого нет, возвращаем null */
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
//получаем новые данные edit.html и выполняем замену
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
        //проходим по каждому человеку из списка, получаем его id
        //removeIf метод ArrayList
    }
}
//обычно общается с БД. Но для примера строим коллекцию