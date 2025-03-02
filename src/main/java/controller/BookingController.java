package controller;

import dto.BookingDTO;
import entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;


    @PostMapping
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.createBooking(bookingDTO);
    }

    @GetMapping("/ordered")
    public List<Booking> getAllBookingsOrdered(){
        return bookingService.getAllBookingsOrdered();
    }

    @GetMapping("/{userId}/{bookingId}")
    public Booking getBookingForUser(@PathVariable Long userId, @PathVariable Long bookingId){
        return bookingService.getBookingForUser(userId,bookingId);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/flight/{flightId}")
    public List<Booking> getBookingsByFlight(@PathVariable Long flightId) {
        return bookingService.getBookingsByFlight(flightId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
