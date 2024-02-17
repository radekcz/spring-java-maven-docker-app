package com.rk.springmavendockerbasecore;

import com.rk.springmavendockerbasecore.rest.model.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties({ApplicationProperties.class})
@SpringBootApplication
@ComponentScan({" com.rk.springmavendockerbasecore"})
public class SpringMavenDockerBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringMavenDockerBaseApp.class, args);
    }
}
