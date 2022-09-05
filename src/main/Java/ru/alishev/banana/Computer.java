package ru.alishev.banana;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }
    @Override
    public String toString() {
        return "Computer " + id + " " + musicPlayer.playMusic();
    }
}
