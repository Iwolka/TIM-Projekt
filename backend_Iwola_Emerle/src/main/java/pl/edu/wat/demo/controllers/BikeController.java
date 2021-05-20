package pl.edu.wat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.demo.dtos.BikeRequest;
import pl.edu.wat.demo.dtos.BikeReservationsResponse;
import pl.edu.wat.demo.dtos.BikeResponse;
import pl.edu.wat.demo.entities.RentalEntity;
import pl.edu.wat.demo.services.BikeService;

import java.util.List;

@RestController
public class BikeController {
    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/api/bike")
    public ResponseEntity<List<BikeResponse>> getAll() {
        return new ResponseEntity<>(bikeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/api/bike/{rental_id}")
    public ResponseEntity addNew(@PathVariable int rental_id, @RequestBody BikeRequest bikeRequest) {
        bikeService.addNew(bikeRequest, rental_id);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/api/bike/reservation/{bike_id}")
    public ResponseEntity<BikeReservationsResponse> getReservations(int bike_id) {
        return new ResponseEntity<>(bikeService.getReservations(bike_id), HttpStatus.OK);
    }
}
