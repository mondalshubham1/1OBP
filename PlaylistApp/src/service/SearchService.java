package service;

import exceptions.EmptySearchArgumentException;
import exceptions.SongListEmptyException;
import model.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private List<Song> songs;

    public SearchService(List<Song> songs) {
        if(songs == null || songs.size() == 0) {
            throw new SongListEmptyException("The passed song list is empty!!");
        }
        this.songs = songs;
    }

    public List<Song> searchByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new EmptySearchArgumentException("Song title cannot be null or empty");
        }

        List<Song> results = new ArrayList<>();
        for(Song s : songs) {
            if(s.getTitle().equalsIgnoreCase(title)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByAlbum(String album) {
        if (album == null || album.trim().isEmpty()) {
            throw new EmptySearchArgumentException("Album name cannot be null or empty");
        }
        List<Song> results = new ArrayList<>();
        for(Song s : songs) {
            if(s.getAlbum().equalsIgnoreCase(album)) {
                results.add(s);
            }
        }
        return results;
    }
}
