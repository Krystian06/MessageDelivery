package com.company.MessageDelivery.model;

import com.fasterxml.jackson.databind.JsonNode;


public class WhatsApp extends Communication {

    private String phoneNumber;

    public WhatsApp(Long id, String name, String body, String communicationType, long size, JsonNode deliverySettings, String status, String phoneNumber) {
        super(id, name, body, communicationType, size, deliverySettings, status);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
