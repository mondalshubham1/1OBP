package exceptions;

public class SongListEmptyException extends RuntimeException {
    public SongListEmptyException(String msg) {
        super(msg);
    }
}
