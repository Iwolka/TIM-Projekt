package pl.edu.wat.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.demo.entities.BikeEntity;
import pl.edu.wat.demo.entities.RentalEntity;
import pl.edu.wat.demo.entities.ReservationEntity;
import pl.edu.wat.demo.entities.UserEntity;

@Repository
public interface BikeRepository extends CrudRepository<BikeEntity, Integer> {
   BikeEntity findById(int id);

}