package tzc.fruits;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Component
@Scope(value = "prototype")
public class AppleType {
    private String type;

    public AppleType() {
        this.type = "tip de mar";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
