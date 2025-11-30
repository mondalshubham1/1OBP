package service;

import model.Song;

import java.util.ArrayList;
import java.util.List;

public class StorageService {
    public static List<Song> loadSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("1", "Shape of You", "Ed Sheeran", "Divide", 240));
        songs.add(new Song("2", "Darkhaast", "Arijit", "Shivaay", 200));
        songs.add(new Song("3", "Levitating", "Dua Lipa", "Future Nostalgia", 180));
        return songs;
    }
}
