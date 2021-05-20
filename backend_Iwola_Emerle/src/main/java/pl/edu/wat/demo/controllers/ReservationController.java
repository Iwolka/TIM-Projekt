package pl.edu.wat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.demo.dtos.*;
import pl.edu.wat.demo.services.RentalService;
import pl.edu.wat.demo.services.ReservationService;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/api/reservation")
    public ResponseEntity addNew(@RequestBody ReservationRequest reservationRequest) {
        reservationService.addNew(reservationRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @GetMapping("/api/reservation/{reservation_id}")
    public ResponseEntity<ReservationResponse> getById(@PathVariable int reservation_id) {
        return new ResponseEntity<>(reservationService.getById(reservation_id), HttpStatus.OK);
    }

    @DeleteMapping("/api/reservation/{reservation_id}")
    public ResponseEntity deleteById(@PathVariable int reservation_id) {
        reservationService.deleteById(reservation_id);
        return new ResponseEntity(HttpStatus.OK);
    }


}