package com.company.MessageDelivery.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMAIL")
public class EmailEntity extends CommunicationEntity {

    private String subject;
    private String to;
    private String cc;
    private String bcc;

    public EmailEntity(String name, String body, CommunicationType type, long size, String deliverySettings, String status, String subject, String to, String cc, String bcc) {
        super(name, body, type, size, deliverySettings, status);
        this.subject = subject;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
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
}
