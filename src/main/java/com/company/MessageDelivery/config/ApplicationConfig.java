package com.company.MessageDelivery.config;

import com.company.MessageDelivery.repository.CommunicationRepository;
import com.company.MessageDelivery.repository.FileCommunicationRepository;
import com.company.MessageDelivery.repository.directory.FileRepository;
import com.company.MessageDelivery.repository.directory.FileRepositoryHandler;
import com.company.MessageDelivery.service.CommunicationMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ApplicationConfig {

    @Value("${app.communication-path}")
    private String COMMUNICATION_PATH;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean
    public FileRepository fileRepository() {
        return new FileRepositoryHandler(COMMUNICATION_PATH);
    }

    @Bean
    public CommunicationMapper communicationMapper() {
        return new CommunicationMapper();
    }

    @Bean
    public FileCommunicationRepository fileCommunicationRepository(ObjectMapper objectMapper, CommunicationMapper communicationMapper, CommunicationRepository communicationRepository) {
        return new FileCommunicationRepository(COMMUNICATION_PATH, objectMapper, communicationMapper, communicationRepository);
    }

    @Component
    @ConfigurationProperties(prefix = "app")
    public class CommunicationProperties {
        private String communicationPath;

        public String getCommunicationPath() {
            return communicationPath;
        }

        public void setCommunicationPath(String communicationPath) {
            this.communicationPath = communicationPath;
        }
    }
}
