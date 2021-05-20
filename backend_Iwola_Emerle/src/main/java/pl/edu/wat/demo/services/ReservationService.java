package pl.edu.wat.demo.services;

import pl.edu.wat.demo.dtos.ReservationRequest;
import pl.edu.wat.demo.dtos.ReservationResponse;
import pl.edu.wat.demo.dtos.UserRequest;
import pl.edu.wat.demo.dtos.UserResponse;

public interface ReservationService {

    void addNew(ReservationRequest reservationRequest);
    ReservationResponse getById(int id);
    void deleteById(int id);


}
