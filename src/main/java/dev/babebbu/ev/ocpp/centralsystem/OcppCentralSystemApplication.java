package dev.babebbu.ev.ocpp.centralsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.babebbu.ev.ocpp.centralsystem.utils.ObjectMapperFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class OcppCentralSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcppCentralSystemApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return ObjectMapperFactory.getObjectMapper();
    }

}
