package service;

import entity.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.FlightRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }

    public List<Flight> getFlightsByDateAndOrigin(LocalDateTime departureDate, String origin) {
        return flightRepository.findByDepartureDateAndOrigin(LocalDate.from(departureDate), origin);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

}
