package pl.edu.wat.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wat.demo.entities.RentalEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeResponse {
    private int id;
    private String name;
    private double price;

}
