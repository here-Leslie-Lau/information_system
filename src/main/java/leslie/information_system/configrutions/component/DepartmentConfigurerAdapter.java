package leslie.information_system.configrutions.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class DepartmentConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private DepartmentAdminLoginInterceptor departmentAdminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(departmentAdminLoginInterceptor).addPathPatterns("/departmentAdminPages/index","/grade/**").excludePathPatterns("/grade/student/**");

        super.addInterceptors(registry);
    }
}
