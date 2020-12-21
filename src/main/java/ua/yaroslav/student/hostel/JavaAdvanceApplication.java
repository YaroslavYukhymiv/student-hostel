package ua.yaroslav.student.hostel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ua.yaroslav.student.hostel.dao.entity.Person;
import ua.yaroslav.student.hostel.dao.entity.Student;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class JavaAdvanceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(JavaAdvanceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaAdvanceApplication.class, args);


//        Person person = new Person.Builder("Vasya").address("Perehrestya").age(35).hight(180).number("0232345").weight(120).secondName("Petrovic").build();
//        System.out.println(person.toString());
    }

}
