package service;

import model.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private List<Song> songs;

    public SearchService(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> searchByTitle(String title) {
        List<Song> results = new ArrayList<>();
        for(Song s : songs) {
            if(s.getTitle().equalsIgnoreCase(title)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByAlbum(String album) {
        List<Song> results = new ArrayList<>();
        for(Song s : songs) {
            if(s.getAlbum().equalsIgnoreCase(album)) {
                results.add(s);
            }
        }
        return results;
    }
}
