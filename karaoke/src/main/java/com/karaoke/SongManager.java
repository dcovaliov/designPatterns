package com.karaoke;

import java.util.ArrayList;
import java.util.List;

public class SongManager {

    /**
     * the subject in the Observer Pattern
     * SongManager implementation uses Singleton Pattern
     * to ensure that only one instance of SongManager is managing the songs
     */
    private static SongManager instance;
    private List<String> songs;
    private List<SongView> observers = new ArrayList<>();

    private SongManager() {
        songs = new ArrayList<>();
    }

    public static synchronized SongManager getInstance() {
        if (instance == null) {
            instance = new SongManager();
        }
        return instance;
    }

    /**
     * @param song
     * adds a new song to the list and notifies the observers
     */
    public void addSong(String song) {
        songs.add(song);
        notifyObservers();
    }

    /**
     * @return the current list of songs
     */
    public List<String> getSongs() {
        return songs;
    }

    /**
     * @param observer
     * subscribes an observer to notifications
     */
    public void subscribeObserver(SongView observer) {
        observers.add(observer);
    }

    /**
     * @param observer
     * subscribes an observer from notifications
     */
    public void unsubscribeObserver(SongView observer) {
        observers.remove(observer);
    }

    /**
     * notifies all subscribed observers when the songs list is updated
     */
    private void notifyObservers() {
        for (SongView observer : observers) {
            observer.update();
        }
    }
}
