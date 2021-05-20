package pl.edu.wat.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.demo.entities.RentalEntity;
import pl.edu.wat.demo.entities.ReservationEntity;
import pl.edu.wat.demo.entities.UserEntity;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {
    ReservationEntity findById(int id);
    List<ReservationEntity> findByBikeId(int id);
}