package com.nayak.movievideo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MovievideoApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location=" +
            "classpath:application.yml," +
            "classpath:real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(MovievideoApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}
