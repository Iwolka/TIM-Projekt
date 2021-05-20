package pl.edu.wat.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.demo.dtos.RentalRequest;
import pl.edu.wat.demo.dtos.RentalResponse;
import pl.edu.wat.demo.entities.RentalEntity;
import pl.edu.wat.demo.repositories.RentalRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<RentalResponse> getAll() {
        return StreamSupport.stream(rentalRepository.findAll().spliterator(), false)
                .map(rentalEntity -> new RentalResponse(rentalEntity.getId(), rentalEntity.getName(), rentalEntity.getLongitude(), rentalEntity.getLatitude()))
                .collect(Collectors.toList());
    }

    @Override
    public void addNew(RentalRequest rentalRequest) {
        RentalEntity rentalEntity = new RentalEntity();

        rentalEntity.setName(rentalRequest.getName());

        rentalRepository.save(rentalEntity);
    }
}