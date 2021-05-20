package pl.edu.wat.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.demo.dtos.BikeResponse;
import pl.edu.wat.demo.dtos.ReservationRequest;
import pl.edu.wat.demo.dtos.ReservationResponse;
import pl.edu.wat.demo.dtos.UserResponse;
import pl.edu.wat.demo.entities.BikeEntity;
import pl.edu.wat.demo.entities.ReservationEntity;
import pl.edu.wat.demo.entities.UserEntity;
import pl.edu.wat.demo.repositories.BikeRepository;
import pl.edu.wat.demo.repositories.ReservationRepository;
import pl.edu.wat.demo.repositories.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final BikeRepository bikeRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, BikeRepository bikeRepository){
        this.reservationRepository = reservationRepository;
        this.bikeRepository = bikeRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void addNew(ReservationRequest reservationRequest) {
        UserEntity userEntity = userRepository.findById(reservationRequest.getUserId());
        BikeEntity bikeEntity = bikeRepository.findById(reservationRequest.getBikeId());
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setStartDate(reservationRequest.getStartDate());
        reservationEntity.setEndDate(reservationRequest.getEndDate());
        reservationEntity.setBike(bikeEntity);
        reservationEntity.setUser(userEntity);
        reservationRepository.save(reservationEntity);
    }

    @Override
    public ReservationResponse getById(int id) {
        ReservationEntity reservationEntity = reservationRepository.findById(id);
        if(reservationEntity == null) return new ReservationResponse();
        return new ReservationResponse(reservationEntity.getId(), reservationEntity.getStartDate(), reservationEntity.getEndDate(), new BikeResponse(reservationEntity.getBike().getId(), reservationEntity.getBike().getName(), reservationEntity.getBike().getPrice()),  new UserResponse(reservationEntity.getUser().getId(), reservationEntity.getUser().getName(), reservationEntity.getUser().getSurname()));

    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
