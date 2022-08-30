package ru.alishev.banana;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    private final List<String> songs = new ArrayList<>();

    //блок инициализации объекта Instance initialization block
//Выполняется каждый раз, когда создаётся объект класса
    {
        songs.add("Wind cries Mary");
        songs.add("Paint it black");
        songs.add("Can't seem to make you mine");
    }

    @Override
    public List<String> getSongs() {

        return songs;
    }

    @Override
    public List<String> getSong() {
        return null;
    }
}
