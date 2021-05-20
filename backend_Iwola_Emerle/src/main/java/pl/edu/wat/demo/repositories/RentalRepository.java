package pl.edu.wat.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.demo.entities.BikeEntity;
import pl.edu.wat.demo.entities.RentalEntity;

@Repository
public interface RentalRepository extends CrudRepository<RentalEntity, Integer> {
    RentalEntity findById(int rental_id);
}