package pl.edu.wat.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long longitude;
    private long latitude;

    @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<BikeEntity> bikeList;
}
