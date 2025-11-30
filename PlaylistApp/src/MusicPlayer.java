import model.Song;

public class MusicPlayer {
    private Song currentSong;
    private boolean isPlaying;

    public void play(Song song) {
        if(song != null) {
            this.currentSong = song;
            this.isPlaying = true;
            System.out.println("Playing : " + this.currentSong.getTitle() + " by " + this.currentSong.getArtist());
        }
    }

    public void pause() {
        if(isPlaying) {
            isPlaying = false;
            System.out.println("Paused : " + currentSong.getTitle());
        }
        else {
            System.out.println("No song is currently playing");
        }
    }

    public void resume() {
        if(currentSong != null) {
            if(!isPlaying) {
                isPlaying = true;
                System.out.println("Resumed : " + currentSong.getTitle());
            }
            else {
                System.out.println("Already the song is playing");
            }
        }
        else {
            System.out.println("No Song to resume");
        }
    }

    public void stop() {
        if(currentSong != null) {
            System.out.println("Stopped : " + currentSong.getTitle());
            currentSong = null;
            isPlaying = false;
        }
        else {
            System.out.println("No song is currently playing");
        }
    }

}
