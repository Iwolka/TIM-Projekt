package pl.edu.wat.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalResponse {
    private int id;
    private String name;
    private long longitude;
    private long latitude;
  //  private List<BikeResponse> bikeList;
}