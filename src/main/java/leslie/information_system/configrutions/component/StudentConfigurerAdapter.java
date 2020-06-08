package leslie.information_system.configrutions.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class StudentConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private StudentLoginInterceptor studentLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(studentLoginInterceptor).addPathPatterns("/","/index","/student/quit","/student/update");

        super.addInterceptors(registry);
    }
}
