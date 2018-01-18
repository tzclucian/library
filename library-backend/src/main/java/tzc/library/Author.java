package tzc.library;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Service
@Scope(value = "prototype")
public class Author implements InitializingBean, DisposableBean{
    private String name;

    public Author() {
        this.name = "Lucian";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("s-a distrus beanul");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("s-a creat beanul");
    }
}
