import exceptions.EmptySearchArgumentException;
import exceptions.SongListEmptyException;
import model.MusicPlayer;
import model.Playlist;
import model.Song;
import service.SearchService;
import service.StorageService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
         Key Requirements of the Music Player

             Song Management
             Songs, Songs metadata

             Search of Songs by Song Name, Artist, Album

             Playlist Management
             Create, Update and Delete playlist
             Add and Remove songs from playlist

             Playback functionality :

             Play, Pause, Stop and Resume Songs.
             Ability to play songs in different formats (mp3, wav, aac)


           Components

           1. Song : Represents a single music track
           2. Playlist : Manages a collection of Song
           3. model.MusicPlayer : Core functionality for Playback and Media Controls
           4. SearchService : Enables searching of songs by metadata
           5. StorageService : Handles the retrieval of the song from Storage

         */

        // Load all songs from storage
        //List<Song> songs = StorageService.loadSongs();

        try {
            List<Song> songs = StorageService.loadSongs();
            // Search service
            SearchService searchService = new SearchService(songs);

            List<Song> results = new ArrayList<>();
            try {
                results = searchService.searchByTitle("");
                System.out.println("Songs with title " + "Darkhaast");
            } catch (EmptySearchArgumentException e) {
                System.out.println("Your search query is invalid!!!");
            }
            for(Song s : results) {
                System.out.println(s);
            }

            // Play the first song
            MusicPlayer musicPlayer = new MusicPlayer();
            musicPlayer.play(songs.get(0));
            musicPlayer.pause();
            musicPlayer.resume();
            musicPlayer.stop();

            // Create a playlist

            Playlist playlist = new Playlist("Hits of Arijit");
            playlist.addSong(songs.get(1));
            playlist.addSong(songs.get(2));
            System.out.println("Playlist : " + playlist.getName() + " has these songs " + playlist.getSongs());
        } catch (SongListEmptyException e) {
            System.out.println("Your song list is empty");
        } catch (EmptySearchArgumentException e) {
            System.out.println("Your query is empty");
        }

    }
}