package pl.edu.wat.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeRequest {
    private String name;
    private double price;
    private int amount;
}
