package ru.leonchenko.users.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class YamlPropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        var yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        var configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}