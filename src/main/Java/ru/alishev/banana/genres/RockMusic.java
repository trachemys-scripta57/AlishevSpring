package ru.alishev.banana.genres;

import org.springframework.stereotype.Component;
import ru.alishev.banana.Music;

@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
