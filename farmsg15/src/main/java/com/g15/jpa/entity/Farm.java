package com.g15.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 *
 * @author desaextremo
 */
@Entity
@Table(name = "farm")
public class Farm  implements Serializable {//inicio de la clase

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "address", nullable = false, length = 45)
    private String address;
    @Column(name = "extension", nullable = false)
    private Integer extension;
    @Column(name = "description", nullable = false, length = 450)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("farms")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "farm")
    @JsonIgnoreProperties({"farm", "client"})
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "farm")
    @JsonIgnoreProperties({"farm", "messages"})
    private List<Reservation> reservations;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the extension
     */
    public Integer getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}//fin de la clase
