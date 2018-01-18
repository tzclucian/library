package tzc.fruits;

import org.springframework.stereotype.Component;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Component
public class Worm {
    private String length;

    public Worm() {
        this.length = "lung";
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
