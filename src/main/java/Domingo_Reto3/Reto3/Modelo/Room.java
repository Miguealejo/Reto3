/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer stars;
    private Integer category_id;
    private String hotel;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    @JsonIgnoreProperties("room")
    private Category category;

     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Reservation> reservations;

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    

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
}
