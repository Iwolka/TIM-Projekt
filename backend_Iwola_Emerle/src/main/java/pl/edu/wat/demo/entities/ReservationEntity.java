package pl.edu.wat.demo.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String startDate;
    private String endDate;

    @JoinColumn
    @ManyToOne
    private BikeEntity bike;

    @JoinColumn
    @ManyToOne
    private UserEntity user;
}

