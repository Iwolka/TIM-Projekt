package pl.edu.wat.demo.services;

import pl.edu.wat.demo.dtos.RentalRequest;
import pl.edu.wat.demo.dtos.RentalResponse;
import pl.edu.wat.demo.dtos.UserRequest;
import pl.edu.wat.demo.dtos.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();

    void addNew(UserRequest userRequest);
    UserResponse getById(int user_id);
    void deleteById(int id);
    void update(UserRequest userRequest, int user_id);
}
