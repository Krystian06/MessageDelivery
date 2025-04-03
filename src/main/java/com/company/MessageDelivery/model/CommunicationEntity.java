package com.company.MessageDelivery.model;


import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import java.util.Arrays;
import java.util.stream.Collectors;


@Entity
@Table(name = "Communication")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "communicationType", discriminatorType = DiscriminatorType.STRING)
public class CommunicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String body;


    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "TEXT")
    private JsonNode deliverySettings;

    private long size;
    @Enumerated(EnumType.STRING)
    private CommunicationType type;
    private String status;

    public CommunicationEntity(){}

    public CommunicationEntity(String name, String body, CommunicationType type, long size, JsonNode deliverySettings, String status) {
        this.name = name;
        this.body = body;
        this.type = type;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public CommunicationType getType() {
        return type;
    }

    public void setType(CommunicationType type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public JsonNode getDeliverySettings() {
        return deliverySettings;
    }

    public void setDeliverySettings(JsonNode deliverySettings) {
        this.deliverySettings = deliverySettings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public enum CommunicationType {
        EMAIL, WHATSAPP, SMS, NOTIFICATION;

        public static boolean containsEnum(String enumValue) {
            return Arrays.stream(CommunicationType.values())
                    .map(Enum::name)
                    .collect(Collectors.toSet())
                    .contains(enumValue);
        }
    }

    public enum CommunicationStatus {
        NEW,           // Nowa wiadomość w systemie
        PROCESSING,    // Przetwarzanie
        PROCESSED,     // Gotowe do wysyłki
        DELIVERING,    // W trakcie wysyłki
        DELIVERED,     // Dostarczone
        FAILED,        // Błąd wysyłki
        RETRYING,      // Próba ponownej wysyłki
        CANCELLED      // Anulowane
    }
}
