package ru.alishev.banana.config;

import org.springframework.context.annotation.*;
import ru.alishev.banana.*;
import ru.alishev.banana.genres.ClassicalMusic;
import ru.alishev.banana.genres.RockMusic;
import ru.alishev.banana.genres.RussianMusic;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    @Scope("prototype")
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }
    @Bean
    public RussianMusic russianMusic() {
        return new RussianMusic();
    }
    @Bean
    public List<Music> musicList() {
        //этот лист неизменяемый (immutable)
        return Arrays.asList(classicalMusic(), rockMusic(), russianMusic());
    }
    @Bean
    public MusicPlayer musicPlayer() {

        return new MusicPlayer(musicList());
    }
    @Bean
    public Computer computer() {

        return new Computer(musicPlayer());
    }
}