package ru.alishev.banana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private final ClassicalMusic classicalMusic;
    private final RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void playMusic(MusicGenre genre) {
        Random random = new Random();

// случайное целое число между 0 и 2
        int randomNumber = random.nextInt(3);

        if (genre == MusicGenre.CLASSICAL) {
            //случайная классическая песня
            System.out.println(classicalMusic.getSong().get(randomNumber));
        } else {
            //случайная рок композиция
            System.out.println(rockMusic.getSongs().get(randomNumber));
        }
    }
}

