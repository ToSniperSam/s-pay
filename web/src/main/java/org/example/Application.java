package org.example;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configurable
@EnableConfigurationProperties
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
