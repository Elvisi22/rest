package controller;

import entity.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/search")
    public List<Flight> getFlightsByDateAndOrigin(@RequestParam LocalDateTime departureDate, @RequestParam String origin) {
        return flightService.getFlightsByDateAndOrigin(departureDate, origin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok("Flight deleted successfully");
    }
}
