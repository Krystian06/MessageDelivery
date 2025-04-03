package com.company.MessageDelivery.repository;

import com.company.MessageDelivery.exception.NotFoundCommunicationTypeException;
import com.company.MessageDelivery.exception.NotFoundDirectoryException;
import com.company.MessageDelivery.exception.ParseJsonException;
import com.company.MessageDelivery.model.*;
import com.company.MessageDelivery.service.CommunicationMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileCommunicationRepository {

    private final String COMMUNICATION_PATH;
    private final ObjectMapper objectMapper;
    private final CommunicationMapper communicationMapper;
    private final CommunicationRepository communicationRepository;

    public FileCommunicationRepository(String COMMUNICATION_PATH, ObjectMapper objectMapper, CommunicationMapper communicationMapper, CommunicationRepository communicationRepository) {
        this.COMMUNICATION_PATH = COMMUNICATION_PATH;
        this.objectMapper = objectMapper;
        this.communicationMapper = communicationMapper;
        this.communicationRepository = communicationRepository;
    }

    public void executeReadFiles() {

        try(Stream<Path> files = Files.list(Paths.get(COMMUNICATION_PATH))) {
                files
                        .filter(path -> !Files.isDirectory(path))
                        .filter(path -> path.toString().endsWith(".json")
                                && path.toString().endsWith(".txt"))
                        .forEach(this::mapCommunication);
        } catch (IOException e) {
            throw new NotFoundDirectoryException("Not found main directory");
        }
    }

    private void mapCommunication(Path path) {

        String fileName = path.getFileName().toString();
        String jsonPath = COMMUNICATION_PATH + "\\" + fileName;
        String txtPath =  COMMUNICATION_PATH + "\\" + fileName.replace(".json", ".txt");

        Path jsonFile = Paths.get(jsonPath);
        Path txtFile = Paths.get(txtPath);

        if (Files.exists(jsonFile) && Files.exists(txtFile)) {
            saveFilesInDB(jsonFile, txtFile);
        }
    }

    private void saveFilesInDB(Path jsonFile, Path txtPath) {

        JsonNode jsonNode = readJsonFile(jsonFile);

        String communicationType = jsonNode.get("type").asText().toUpperCase();

        if (!CommunicationEntity.CommunicationType.containsEnum(communicationType)) {
            throw new NotFoundCommunicationTypeException("It's not possible to handle " +
                    "this type of communication");
        }

        CommunicationEntity communicationEntity = communicationMapper.mapToEntity(jsonNode, txtPath);

        System.out.println(communicationEntity);
        communicationRepository.save(communicationEntity);
    }

    private JsonNode readJsonFile(Path jsonFile) {

        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(Files.readAllBytes(jsonFile));
        } catch (IOException io) {
            throw new ParseJsonException("It's not possible to parse Json file.");
        }
        return jsonNode;
    }
}
