package com.company.MessageDelivery.model;

import com.fasterxml.jackson.databind.JsonNode;

public class Email extends Communication {

    private String subject;
    private String recipient;
    private String cc;
    private String bcc;

    public Email(Long id, String name, String body, String communicationType, long size, JsonNode deliverySettings, String status, String subject, String recipient, String cc, String bcc) {
        super(id, name, body, communicationType, size, deliverySettings, status);
        this.subject = subject;
        this.recipient = recipient;
        this.cc = cc;
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
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
}
