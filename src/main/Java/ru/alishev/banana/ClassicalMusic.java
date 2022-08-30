package ru.alishev.banana;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private final List<String> songs = new ArrayList<>();
    {
        songs.add("Hungarian Rhapsody");
        songs.add("Symphony no.5 in C Minor, op.67");
        songs.add("Night on Bald Mountain");
    }

    @Override
    public List<String> getSongs() {
        return null;
    }

    @Override
    public List<String> getSong() {

        return songs;
    }
}
