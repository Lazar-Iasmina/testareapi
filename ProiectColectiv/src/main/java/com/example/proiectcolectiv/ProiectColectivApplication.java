package com.example.proiectcolectiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProiectColectivApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(ProiectColectivApplication.class, args);
         //SpringApplication app = new SpringApplication(ProiectColectivApplication.class);
         //app.setDefaultProperties(Collections.singletonMap("server.port", "3000"));
         //app.run(args);
         DataBase.createTableUser("User");
         DataBase.createTablePost("Post");
         DataBase.createTableFavorite("Favorite");
         DataBase.createTableBadges("Badges");
         DataBase.createTableComment("Comment");
         DataBase.createTableQuestionLabel("Label");
    }

}
