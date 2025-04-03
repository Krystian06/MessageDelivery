package com.company.MessageDelivery.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("NOTIFICATION")
public class NotificationEntity extends CommunicationEntity {

    private String deviceToken;

    public NotificationEntity(){}

    public NotificationEntity(String name, String body, CommunicationType type, long size, String deliverySettings, String status, String deviceToken) {
        super(name, body, type, size, deliverySettings, status);
        this.deviceToken = deviceToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
