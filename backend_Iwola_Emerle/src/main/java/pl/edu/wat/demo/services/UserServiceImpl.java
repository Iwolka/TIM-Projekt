package pl.edu.wat.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.demo.dtos.RentalResponse;
import pl.edu.wat.demo.dtos.UserRequest;
import pl.edu.wat.demo.dtos.UserResponse;
import pl.edu.wat.demo.entities.UserEntity;
import pl.edu.wat.demo.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<UserResponse> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(userEntity -> new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getSurname()))
                .collect(Collectors.toList());
    }

    @Override
    public void addNew(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setSurname(userRequest.getSurname());
        userRepository.save(userEntity);

    }

    @Override
    public UserResponse getById(int user_id) {
        UserEntity userEntity = userRepository.findById(user_id);
        if(userEntity == null) return new UserResponse();
        return new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getSurname());
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserRequest userRequest, int user_id) {
        UserEntity userEntity = userRepository.findById(user_id);
        userEntity.setName(userRequest.getName());
        userEntity.setSurname(userRequest.getSurname());
        userRepository.save(userEntity);
    }

}
