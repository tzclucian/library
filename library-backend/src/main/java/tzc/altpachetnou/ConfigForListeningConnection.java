package tzc.altpachetnou;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import tzc.altpachet.LibraryConfig;
import tzc.library.ConnectionThatListens;

/**
 * @author Lucian Tuca
 * @date 18/01/2018
 */
@Configuration
@Import(LibraryConfig.class)
public class ConfigForListeningConnection implements InitializingBean {

    @Autowired
    private ConnectionThatListens connectionThatListens;

    @Override
    public void afterPropertiesSet() throws Exception {
        connectionThatListens.listen();
    }
}
