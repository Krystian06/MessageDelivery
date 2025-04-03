package com.company.MessageDelivery.service;

import com.company.MessageDelivery.exception.NotFoundCommunicationTypeException;
import com.company.MessageDelivery.model.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommunicationMapper {

    public CommunicationEntity mapToEntity(JsonNode jsonNode, Path txtPath) {

        String communicationType = jsonNode.get("type").asText().toUpperCase();

        if (!CommunicationEntity.CommunicationType.containsEnum(communicationType)) {
            throw new NotFoundCommunicationTypeException("It's not possible to handle " +
                    "this type of communication");
        }

        CommunicationEntity.CommunicationType type = CommunicationEntity.CommunicationType.valueOf(communicationType);

        return new CommunicationEntity(
                readNameFile(txtPath),
                readTextFile(txtPath),
                type,
                readSizeFile(txtPath),
                jsonNode,
                CommunicationEntity.CommunicationStatus.NEW.name()
        );
    }

    private String readNameFile(Path txtFile) {
        return txtFile.getFileName().toString();
    }

    private long readSizeFile(Path txtFile) {

        long sizeFile = 0L;
        try {
            sizeFile = Files.size(txtFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sizeFile;
    }

    private String readTextFile(Path txtFile) {

        String content = null;
        try {
            content = Files.readString(txtFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public Communication mapToDto(CommunicationEntity communicationEntity) {

        if (communicationEntity == null) {
            return null;
        }

        return new Communication(
                communicationEntity.getId(),
                communicationEntity.getName(),
                communicationEntity.getBody(),
                communicationEntity.getType().name(),
                communicationEntity.getSize(),
                communicationEntity.getDeliverySettings(),
                communicationEntity.getStatus()
        );
    }
}
