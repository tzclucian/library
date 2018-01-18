package tzc.fruits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Component
public class Apple extends Fruit {

    @Autowired
    private AppleType appleType;

    public AppleType getAppleType() {
        return appleType;
    }

    public void setAppleType(AppleType appleType) {
        this.appleType = appleType;
    }
}
