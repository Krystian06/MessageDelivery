package com.company.MessageDelivery.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Notification extends Communication {

    private String deviceToken;

    public Notification(Long id, String name, String body, String communicationType, long size, JsonNode deliverySettings, String status, String deviceToken) {
        super(id, name, body, communicationType, size, deliverySettings, status);
        this.deviceToken = deviceToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
