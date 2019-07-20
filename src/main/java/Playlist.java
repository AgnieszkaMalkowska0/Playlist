import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Agnieszka on 15.07.2019.
 */

@Data
public class Playlist implements Playable{

    private List<Playable> tracks = new ArrayList<Playable>();

    private PlayMode playMode;


    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }

    public Playlist() {
        playMode = PlayMode.SEQUENCE;
    }

    public void add(Playable playable) {

        tracks.add(playable);
    }

    public void play() {

        switch(playMode) {
            case SEQUENCE:
                playSequence();
                break;
            case RANDOM:
                playRandom();
                break;
            case LOOP:
                playLoop();
                break;

        }
    }

    void playSequence(){
        for (Playable track : tracks) {
            track.play();
        }
    }

    void playRandom() {
        List<Playable> playListToPlay = new ArrayList<Playable>(tracks);
        Collections.shuffle(playListToPlay);
        for (Playable track : tracks) {
            track.play();
        }

    }

    void playLoop() {
        int max = 10;
        for (int i = 0; i <max ; i++) {
            playSequence();
        }
    }


    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.add(new Movie("Casablanca"));
        playlist.add(new Movie("Poranek kojota"));
        playlist.add(new Movie("Ojciec chrzestny"));
        playlist.add(new Song("Brown Sugar", "Rolling Stones"));

        Playlist playlist2 = new Playlist();
        playlist2.add(new Movie("Killer"));
        playlist2.add(new Song("O bladi O blada", "The Beatles"));
        playlist.add(playlist2);
        playlist.setPlayMode(PlayMode.RANDOM);

        playlist.play();
    }


}
