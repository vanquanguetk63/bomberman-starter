package uet.oop.bomberman;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

public class Sound {
    public static void Menu() throws FileNotFoundException, IOException
    {
        InputStream music = new FileInputStream(new File("res/audio/music.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }
    public static void Explosion() throws FileNotFoundException, IOException
    {
        InputStream music = new FileInputStream(new File("res/audio/explosion.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }
    public static void NewBomb() throws FileNotFoundException, IOException
    {
        InputStream music = new FileInputStream(new File("res/audio/newbomb.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }
    public static void MonsterDie() throws FileNotFoundException, IOException
    {
        InputStream music = new FileInputStream(new File("res/audio/monster_die.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }
    public static void Die() throws FileNotFoundException, IOException
    {
        InputStream music = new FileInputStream(new File("res/audio/die.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }

    public static void Item() throws FileNotFoundException, IOException
    {
        InputStream music = new FileInputStream(new File("res/audio/item.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }

    public static void Win() throws FileNotFoundException, IOException {
        InputStream music = new FileInputStream(new File("res/audio/win.wav"));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    }

}