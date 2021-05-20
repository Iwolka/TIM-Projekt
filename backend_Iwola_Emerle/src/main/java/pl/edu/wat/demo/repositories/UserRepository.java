package pl.edu.wat.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.demo.entities.RentalEntity;
import pl.edu.wat.demo.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findById(int id);

}
