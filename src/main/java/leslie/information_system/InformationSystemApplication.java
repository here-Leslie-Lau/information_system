package leslie.information_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "leslie.information_system.mapper")
public class InformationSystemApplication{

    public static void main(String[] args) {
        SpringApplication.run(InformationSystemApplication.class, args);
    }

}
