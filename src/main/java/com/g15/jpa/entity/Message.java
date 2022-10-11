package com.g15.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author desaextremo
 */

@Entity
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    @Column(nullable = false, length = 255)
    private String messageText;
    
    /*
    many to one : es la forma de crear llaves foraneas
    */
    @ManyToOne
    @JoinColumn(name="client_id")
    //ignore mensajes del cliente   
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="farm_id")
    //ignorar los detalles del mensaje
    @JsonIgnoreProperties({"messages","reservations"})
    private Farm farm;

    /**
     * @return the idMessage
     */
    public Long getIdMessage() {
        return idMessage;
    }

    /**
     * @param idMessage the idMessage to set
     */
    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the farm
     */
    public Farm getFarm() {
        return farm;
    }

    /**
     * @param farm the farm to set
     */
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    
}
