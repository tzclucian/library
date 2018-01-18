package tzc.fruits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Component
public class Fruit {

    @Autowired
    private Worm worm;

    @Autowired
    private AppleType appleType;

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public AppleType getAppleType() {
        return appleType;
    }

    public void setAppleType(AppleType appleType) {
        this.appleType = appleType;
    }
}
