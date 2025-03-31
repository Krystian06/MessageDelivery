package com.company.MessageDelivery.model;


public class Communication {

    private Long id;

    private String name;
    private String body;
    private String communicationType;
    private long size;
    private String deliverySettings;
    private String status;

    private String subject;
    private String to;
    private String cc;
    private String bcc;

    private String deviceToken;

    private String phoneNumber;

    public Communication(Long id, String name, String body, String communicationType, long size, String deliverySettings, String status, String subject, String to, String cc, String bcc, String deviceToken, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.communicationType = communicationType;
        this.size = size;
        this.deliverySettings = deliverySettings;
        this.status = status;
        this.subject = subject;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.deviceToken = deviceToken;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDeliverySettings() {
        return deliverySettings;
    }

    public void setDeliverySettings(String deliverySettings) {
        this.deliverySettings = deliverySettings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
