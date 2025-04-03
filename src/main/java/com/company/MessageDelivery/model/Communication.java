package com.company.MessageDelivery.model;


import com.fasterxml.jackson.databind.JsonNode;

public class Communication {

    private Long id;

    private String name;
    private String body;
    private String communicationType;
    private long size;
    private JsonNode deliverySettings;
    private String status;

    public Communication(Long id, String name, String body, String communicationType, long size, JsonNode deliverySettings, String status) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.communicationType = communicationType;
        this.size = size;
        this.deliverySettings = deliverySettings;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getCommunicationType() {
        return communicationType;
    }

    public long getSize() {
        return size;
    }

    public JsonNode getDeliverySettings() {
        return deliverySettings;
    }

    public String getStatus() {
        return status;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setDeliverySettings(JsonNode deliverySettings) {
        this.deliverySettings = deliverySettings;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
