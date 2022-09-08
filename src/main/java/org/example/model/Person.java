package org.example.model;

import jakarta.persistence.*;

@Entity //помечает классы связанные с БД
//@Table(name = "Person") //явно указываем имя таблицы для данной сущности
@Table
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "seq_generator_person")
    @SequenceGenerator(name = "seq_generator_person",
    sequenceName = "person_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person() {}

//    public Person(int id, String name, int age) {
    public Person(String name, int age) {
//        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
