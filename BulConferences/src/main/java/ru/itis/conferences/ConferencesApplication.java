package ru.itis.conferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.itis.conferences.configuration.SenderConfig;

import java.util.Properties;

@SpringBootApplication
public class ConferencesApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public SenderConfig sender() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return new SenderConfig("instamendil14@gmail.com", "1234567890246813579A", properties);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConferencesApplication.class, args);
    }

}
