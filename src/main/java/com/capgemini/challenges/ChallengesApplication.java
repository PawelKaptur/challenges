package com.capgemini.challenges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class ChallengesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChallengesApplication.class, args);
    }
}
