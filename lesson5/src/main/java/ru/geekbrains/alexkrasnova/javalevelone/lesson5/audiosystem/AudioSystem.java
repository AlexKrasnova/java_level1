package ru.geekbrains.alexkrasnova.javalevelone.lesson5.audiosystem;

public class AudioSystem {

    private Brand brand;
    private String color;
    private Mode mode;
    private int volume;
    private int MAX_VOLUME = 30;
    private boolean enabled;
    private boolean playing;

    public AudioSystem(Brand brand, String color) {
        this.brand = brand;
        this.color = color;
        mode = Mode.BLUETOOTH;
        enabled = false;
        playing = false;
        volume = MAX_VOLUME / 2;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setVolume(int volume) {
        if (volume > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else {
            this.volume = volume;
        }
    }

    public void turnOn() {
        enabled = true;
        System.out.println("Аудиосистема включилась.");
    }

    public void turnOff() {
        playing = false;
        enabled = false;
        System.out.println("Аудиосистема выключилась.");
    }


    public void printInfo() {
        System.out.printf("\nАудиосистема %s, %s.\nВключена: %b;\nMode: %s\nИграет музыку: %b\nГромкость: %d\n\n", brand.toString(), color, enabled, mode.toString(), playing, volume);
    }


    public void play() {
        if (enabled && !playing) {
            playing = true;
            System.out.println("Аудиосистема играет музыку.");
        } else if (!enabled) {
            System.out.println("Аудиосистема выключена, сначала включите ее.");
        }
    }

    public void stop() {
        if (playing) {
            playing = false;
            System.out.println("Музыка выключилась.");
        }
    }


    public void nextTrack() {
        if (playing) {
            System.out.println("Аудиосистема проигрывает следующий трек.");
        }
    }

    public void previousTrack() {
        if (playing) {
            System.out.println("Аудиосистема проигрывает предыдущий трек.");
        }
    }


}
