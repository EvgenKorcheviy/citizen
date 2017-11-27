package com.space.traveler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@Import({
        HibernateConfig.class,
        WebConfiguration.class,
        WebSecurityConfig.class
})
@ComponentScan(basePackages = "com.space.traveler.service")
public class RootConfig {

    @Value("${traveler.env:local}")
    private static String environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(
                //new ClassPathResource("default.properties"),
                new ClassPathResource(environment + ".properties")
                //new FileSystemResource("/etc/journal/app.properties")
        );
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }

}
