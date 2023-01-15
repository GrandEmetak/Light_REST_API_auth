package com.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * т.е. при каждом запросе на формирование отчета у нас будет генерироваться новый отчет с новой датой.
 * Добавим Bean в класс запуска приложения:
 * -@Bean
 * public RestTemplate getTemplate() {
 */
@SpringBootApplication
public class AuthApplication extends SpringBootServletInitializer {

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
