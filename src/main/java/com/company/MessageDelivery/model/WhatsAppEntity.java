package com.company.MessageDelivery.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WHATSUP")
public class WhatsAppEntity extends CommunicationEntity {

    private String phoneNumber;

    public WhatsAppEntity(){}

    public WhatsAppEntity(String name, String body, CommunicationType type, long size, String deliverySettings, String status, String phoneNumber) {
        super(name, body, type, size, deliverySettings, status);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
