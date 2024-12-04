package com.karaoke;

public class SongListDisplay implements SongView {
    /**
     * SongListDisplay is a concrete observer that implements the SongView interface
     */
    private SongManager songManager;

    public SongListDisplay(SongManager songManager) {
        this.songManager = songManager;
        songManager.subscribeObserver(this);
    }

    @Override
    public void update() {
        displaySongs();
    }

    public void displaySongs() {
        System.out.println("Updated song list:");
        for (String song : songManager.getSongs()) {
            System.out.println(song);
        }
    }

    public void stopObserving() {
        songManager.unsubscribeObserver(this);
    }
}
