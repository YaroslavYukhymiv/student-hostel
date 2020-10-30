package ua.yaroslav.student.hostel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JavaAdvanceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(JavaAdvanceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaAdvanceApplication.class, args);
    }

}
