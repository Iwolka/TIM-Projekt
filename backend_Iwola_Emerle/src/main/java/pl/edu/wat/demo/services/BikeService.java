package pl.edu.wat.demo.services;

import pl.edu.wat.demo.dtos.BikeRequest;
import pl.edu.wat.demo.dtos.BikeReservationsResponse;
import pl.edu.wat.demo.dtos.BikeResponse;
import pl.edu.wat.demo.entities.RentalEntity;

import java.util.List;

public interface BikeService {
    List<BikeResponse> getAll();

    void addNew(BikeRequest bikeRequest, int rental);
    BikeReservationsResponse getReservations(int id);
}
