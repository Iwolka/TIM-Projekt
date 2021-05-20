package pl.edu.wat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.demo.dtos.RentalRequest;
import pl.edu.wat.demo.dtos.RentalResponse;
import pl.edu.wat.demo.services.RentalService;

import java.util.List;

@RestController
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/api/rental")
    public ResponseEntity<List<RentalResponse>> getAll() {
        return new ResponseEntity<>(rentalService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/api/rental")
    public ResponseEntity addNew(@RequestBody RentalRequest rentalRequest) {
        rentalService.addNew(rentalRequest);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
