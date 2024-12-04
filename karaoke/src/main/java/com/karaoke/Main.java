package com.karaoke;

public class Main {
    public static void main(String[] args) {
        SongManager songManager = SongManager.getInstance();
        SongListDisplay songListView = new SongListDisplay(songManager);

        System.out.println("Adding songs while observer is active:");
        songManager.addSong("Country Roads");
        songManager.addSong("Ain't no sunshine");

        songListView.stopObserving();

        System.out.println("Adding songs after observer is removed:");
        songManager.addSong("Remember the time");
        songManager.addSong("Smooth criminal");
    }
}
