package com.company.MessageDelivery.controller;

import com.company.MessageDelivery.model.Communication;
import com.company.MessageDelivery.service.CommunicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/communications")
public class CommunicationController {

    private final CommunicationService communicationService;

    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @PostMapping("/add")
    public List<String> addCommunicationFiles(@RequestParam("files") MultipartFile[] files) {
        return communicationService.addCommunication(files);
    }

    @GetMapping("/getAll")
    public List<Communication> getAllCommunications() {
        return communicationService.getAllCommunications();
    }

    @PutMapping("/update/{communicationId}")
    public Long updateCommunication(@PathVariable Long communicationId, @RequestBody Communication updatedCommunication) {
        return communicationService.updateCommunication(communicationId, updatedCommunication);
    }

    @DeleteMapping("/delete/{communicationId}")
    public Long deleteCommunication(@PathVariable Long communicationId) {
        return communicationService.deleteCommunication(communicationId);
    }

    @GetMapping("/find/{communicationId}")
    public Communication findCommunicationById(@PathVariable Long communicationId) {
        return communicationService.findCommunicationById(communicationId);
    }

    @GetMapping("/{id}/deliver")
    public void communicationDeliver(@PathVariable Long communicationId) {
        communicationService.deliverCommunication(communicationId);
    }
}
