package karl.pizza.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"karl.pizza.controller", "karl.pizza.application"})
public class Application {	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
