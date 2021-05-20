package pl.edu.wat.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
    private int id;
    private String startDate;
    private String endDate;
    private BikeResponse bike;
    private UserResponse user;
}
