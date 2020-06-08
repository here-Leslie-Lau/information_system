package leslie.information_system.configrutions;

import leslie.information_system.configrutions.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class SpringConfig {

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
