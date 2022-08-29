package ru.alishev.banana;

public class MusicPlayer {
    private final Music music;
// зависимость от интерфейса Music

              ///// IoC /////
    public MusicPlayer(Music music) {
// используем полиморфизм Music music
        this.music = music;
// присваиваем нашему полю то, что было внедрено
    }
    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
