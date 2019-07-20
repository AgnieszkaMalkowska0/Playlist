import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Agnieszka on 15.07.2019.
 */
@Data
@AllArgsConstructor
public class Movie implements Playable{

    private String title;

    public void play() {
        System.out.println("Film: " + title);
    }

}
