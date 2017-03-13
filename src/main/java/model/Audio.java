package model;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;
import javax.sound.sampled.*;

public class Audio extends Thread{

    AudioInputStream audioInputStream = null;
    SourceDataLine line;

    public void run(){

        AudioStream audioStream;
        AudioData audioData;
        AudioPlayer audioPlayer = AudioPlayer.player;

        try {
            audioStream = new AudioStream(new FileInputStream("ressource/musique.wav"));
            AudioPlayer.player.start(audioStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
