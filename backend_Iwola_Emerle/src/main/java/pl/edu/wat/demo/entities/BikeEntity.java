package pl.edu.wat.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private int amount;

    @JoinColumn
    @ManyToOne
    private RentalEntity rental;

    @OneToMany(mappedBy = "bike", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ReservationEntity> reservationList;
}
