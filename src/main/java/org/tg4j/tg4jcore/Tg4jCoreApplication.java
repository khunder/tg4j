package org.tg4j.tg4jcore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication( exclude = {
        ThymeleafAutoConfiguration.class,
})
public class Tg4jCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tg4jCoreApplication.class, args);

    }

}
