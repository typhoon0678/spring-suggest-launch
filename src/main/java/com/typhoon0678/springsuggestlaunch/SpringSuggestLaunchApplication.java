package com.typhoon0678.springsuggestlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringSuggestLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSuggestLaunchApplication.class, args);
    }

}
