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

        if (CommunicationEntity.CommunicationType.EMAIL.equals(type)) {
            return new EmailEntity(
                    readNameFile(txtPath),
                    readTextFile(txtPath),
                    type,
                    readSizeFile(txtPath),
                    null,
                    CommunicationEntity.CommunicationStatus.NEW.name(),
                    jsonNode.get("subject").asText(),
                    jsonNode.get("to").asText(),
                    jsonNode.get("cc").asText(),
                    jsonNode.get("bcc").asText());

        } else if (CommunicationEntity.CommunicationType.SMS.equals(type)) {
            return new SMSEntity(
                    readNameFile(txtPath),
                    readTextFile(txtPath),
                    type,
                    readSizeFile(txtPath),
                    null,
                    CommunicationEntity.CommunicationStatus.NEW.name(),
                    jsonNode.get("phone_number").asText());

        } else if(CommunicationEntity.CommunicationType.WHATSAPP.equals(type)) {
            return new WhatsAppEntity(
                    readNameFile(txtPath),
                    readTextFile(txtPath),
                    type,
                    readSizeFile(txtPath),
                    null,
                    CommunicationEntity.CommunicationStatus.NEW.name(),
                    jsonNode.get("phone_number").asText());

        } else if(CommunicationEntity.CommunicationType.NOTIFICATION.equals(type)) {
            return new NotificationEntity(
                    readNameFile(txtPath),
                    readTextFile(txtPath),
                    type,
                    readSizeFile(txtPath),
                    null,
                    CommunicationEntity.CommunicationStatus.NEW.name(),
                    jsonNode.get("device_token").asText());
        }

        return null;
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

        CommunicationEntity.CommunicationType communicationType = communicationEntity.getType();

        if (CommunicationEntity.CommunicationType.EMAIL.equals(communicationType)) {

            EmailEntity emailEntity = (EmailEntity) communicationEntity;
            return new Communication(
                    emailEntity.getId(),
                    emailEntity.getName(),
                    emailEntity.getBody(),
                    emailEntity.getType().name(),
                    emailEntity.getSize(),
                    emailEntity.getDeliverySettings(),
                    emailEntity.getStatus(),
                    emailEntity.getSubject(),
                    emailEntity.getTo(),
                    emailEntity.getCc(),
                    emailEntity.getBcc(),
                    null,
                    null
            );

        } else if (CommunicationEntity.CommunicationType.SMS.equals(communicationType)) {

            SMSEntity smsEntity = (SMSEntity) communicationEntity;
            return new Communication(
                    smsEntity.getId(),
                    smsEntity.getName(),
                    smsEntity.getBody(),
                    smsEntity.getType().name(),
                    smsEntity.getSize(),
                    smsEntity.getDeliverySettings(),
                    smsEntity.getStatus(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    smsEntity.getPhoneNumber());

        } else if (CommunicationEntity.CommunicationType.WHATSAPP.equals(communicationType)) {

            WhatsAppEntity whatsAppEntity = (WhatsAppEntity) communicationEntity;
            return new Communication(
                    whatsAppEntity.getId(),
                    whatsAppEntity.getName(),
                    whatsAppEntity.getBody(),
                    whatsAppEntity.getType().name(),
                    whatsAppEntity.getSize(),
                    whatsAppEntity.getDeliverySettings(),
                    whatsAppEntity.getStatus(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    whatsAppEntity.getPhoneNumber());

        } else if (CommunicationEntity.CommunicationType.NOTIFICATION.equals(communicationType)) {

            NotificationEntity notificationEntity = (NotificationEntity) communicationEntity;
            return new Communication(
                    notificationEntity.getId(),
                    notificationEntity.getName(),
                    notificationEntity.getBody(),
                    notificationEntity.getType().name(),
                    notificationEntity.getSize(),
                    notificationEntity.getDeliverySettings(),
                    notificationEntity.getStatus(),
                    null,
                    null,
                    null,
                    null,
                    notificationEntity.getDeviceToken(),
                    null);
        }
        return null;
    }
}
