package com.company.MessageDelivery.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("SMS")
public class SMSEntity extends CommunicationEntity {

    private String phoneNumber;

    public SMSEntity(String name, String body, CommunicationType type, long size, String deliverySettings, String status, String phoneNumber) {
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
