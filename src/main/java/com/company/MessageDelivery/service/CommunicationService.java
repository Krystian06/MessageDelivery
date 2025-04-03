package com.company.MessageDelivery.service;

import com.company.MessageDelivery.exception.NotFoundCommunicationException;
import com.company.MessageDelivery.exception.NotFoundCommunicationTypeException;
import com.company.MessageDelivery.model.*;
import com.company.MessageDelivery.repository.CommunicationRepository;
import com.company.MessageDelivery.repository.FileCommunicationRepository;
import com.company.MessageDelivery.repository.directory.FileRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CommunicationService {

    private final CommunicationRepository communicationRepository;
    private final CommunicationMapper communicationMapper;
    private final FileRepository fileRepository;
    private final FileCommunicationRepository fileCommunicationRepository;


    public CommunicationService(CommunicationRepository communicationRepository, CommunicationMapper communicationMapper, FileRepository fileRepository, FileCommunicationRepository fileCommunicationRepository) {
        this.communicationRepository = communicationRepository;
        this.communicationMapper = communicationMapper;
        this.fileRepository = fileRepository;
        this.fileCommunicationRepository = fileCommunicationRepository;
    }

    public List<String> addCommunication(MultipartFile[] files) {
        return fileRepository.saveFiles(files);
    }

    public List<Communication> getAllCommunications() {
        return communicationRepository.findAll()
                .stream()
                .map(communicationMapper::mapToDto)
                .toList();
    }

    public Long updateCommunication(Long communicationId, Communication updatedCommunication) {
        return communicationRepository.findById(communicationId)
                .map(existingCommunicationEntity -> {
                    CommunicationEntity communicationEntity = updateProcess(existingCommunicationEntity, updatedCommunication);
                    communicationRepository.save(communicationEntity);
                    return communicationId;
                }).orElseThrow(() -> new NotFoundCommunicationException("Not found communication: " + communicationId));
    }

    private CommunicationEntity updateProcess(CommunicationEntity existingCommunicationEntity,
                               Communication updatedCommunication) {

        JsonNode updateDeliverySettings = updatedCommunication.getDeliverySettings();
        String type = updateDeliverySettings.get("type").asText();

        if(!CommunicationEntity.CommunicationType.containsEnum(type)) {
            throw new NotFoundCommunicationTypeException("It's not possible to update " +
                    "this type of communication");
        }

        if (!existingCommunicationEntity.getBody().equals(updatedCommunication.getBody())) {
            existingCommunicationEntity.setBody(updatedCommunication.getBody());
        }

        if (!existingCommunicationEntity.getDeliverySettings().equals(updateDeliverySettings)) {
            existingCommunicationEntity.setDeliverySettings(updateDeliverySettings);
        }
        return existingCommunicationEntity;
    }

    public Long deleteCommunication(Long communicationId) {
        return communicationRepository.findById(communicationId)
                .map(communicationEntity -> {
                    communicationRepository.deleteById(communicationId);
                    return communicationId;
                }).orElseThrow(() -> new NotFoundCommunicationException("Not found communication"));
    }

    public Communication findCommunicationById(Long communicationId) {
        return communicationRepository.findById(communicationId)
                .map(communicationMapper::mapToDto)
                .orElseThrow(() -> new NotFoundCommunicationException("Not found communication"));
    }

    public void deliverCommunication(Long communicationId) {
        Communication communication = findCommunicationById(communicationId);

        if (communication != null && !communication.getCommunicationType().equals("DELIVERED")) {
            //sending using specific API depends on type of message
        }

    }

    public void processFiles() {
        fileCommunicationRepository.executeReadFiles();
    }

}
