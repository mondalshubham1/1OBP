package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public void addSong(Song song) {
        if (song != null)
            songs.add(song);
    }

    public void removeSong(Song song) {
        if(song != null)
            songs.remove(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public double getPlaylistDuration() {
        double totalPlaylistDuration = 0;
        for(Song s : songs) {
            totalPlaylistDuration += s.getDuration();
        }
        return totalPlaylistDuration;
    }
}
