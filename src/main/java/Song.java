import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Agnieszka on 15.07.2019.
 */
@AllArgsConstructor
@Data
public class Song implements  Playable {

    private String name;
    private String author;

    public void play() {
        System.out.println("Muzyka: " + author + ", " + name);
    }
}
