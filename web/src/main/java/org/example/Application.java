package org.example;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@Configurable
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
