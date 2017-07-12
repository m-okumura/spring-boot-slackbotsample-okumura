package app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SlackSpringBootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SlackSpringBootApplication.class).web(false).run(args);
    }

}
