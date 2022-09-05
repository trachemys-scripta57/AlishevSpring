package ru.alishev.banana;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alishev.banana.config.SpringConfig;
import ru.alishev.banana.genres.ClassicalMusic;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );
       MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);


        System.out.println(musicPlayer.playMusic());

        context.close();
    }
}
