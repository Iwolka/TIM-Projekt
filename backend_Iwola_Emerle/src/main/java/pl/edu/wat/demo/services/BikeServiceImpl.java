package pl.edu.wat.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.demo.dtos.BikeRequest;
import pl.edu.wat.demo.dtos.BikeReservationsResponse;
import pl.edu.wat.demo.dtos.BikeResponse;
import pl.edu.wat.demo.entities.BikeEntity;
import pl.edu.wat.demo.entities.RentalEntity;
import pl.edu.wat.demo.entities.ReservationEntity;
import pl.edu.wat.demo.repositories.BikeRepository;
import pl.edu.wat.demo.repositories.RentalRepository;
import pl.edu.wat.demo.repositories.ReservationRepository;
import pl.edu.wat.demo.utils.DateParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BikeServiceImpl implements  BikeService{
    private final BikeRepository bikeRepository;
    private final RentalRepository rentalRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public BikeServiceImpl(BikeRepository bikeRepository, RentalRepository rentalRepository, ReservationRepository reservationRepository) {
        this.bikeRepository = bikeRepository;
        this.rentalRepository = rentalRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<BikeResponse> getAll() {
        return StreamSupport.stream(bikeRepository.findAll().spliterator(), false)
                .map(bikeEntity -> new BikeResponse(bikeEntity.getId(), bikeEntity.getName(), bikeEntity.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void addNew(BikeRequest bikeRequest, int rental_id) {
        BikeEntity bikeEntity = new BikeEntity();
        bikeEntity.setName(bikeRequest.getName());
        bikeEntity.setAmount(bikeRequest.getAmount());
        bikeEntity.setPrice(bikeRequest.getPrice());
        RentalEntity rentalEntity = rentalRepository.findById(rental_id);
        bikeEntity.setRental(rentalEntity);

        bikeRepository.save(bikeEntity);
    }

    @Override
    public BikeReservationsResponse getReservations(int bike_id) {
        BikeReservationsResponse reservationsResponse = new BikeReservationsResponse();
        List<String> dates = new ArrayList<String>();
        List<ReservationEntity> reservations = reservationRepository.findByBikeId(bike_id);
        for(ReservationEntity reservation : reservations){
            dates.addAll(DateParser.parseRangeToList(reservation.getStartDate(), reservation.getEndDate()));
        }
        reservationsResponse.setDates(dates);
        return reservationsResponse;
    }
}
