package pl.edu.wat.demo.services;

import pl.edu.wat.demo.dtos.RentalRequest;
import pl.edu.wat.demo.dtos.RentalResponse;

import java.util.List;

public interface RentalService {
    List<RentalResponse> getAll();

    void addNew(RentalRequest rentalRequest);
}