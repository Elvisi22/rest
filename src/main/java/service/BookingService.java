package service;

import dto.BookingDTO;
import entity.Booking;
import entity.Flight;
import entity.User;
import mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookingRepository;
import repository.FlightRepository;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private FlightRepository flightRepository;
    private BookingMapper bookingMapper;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        User user = userRepository.findById(bookingDTO.getUserId()).orElseThrow();
        Flight flight = flightRepository.findById(bookingDTO.getFlightId()).orElseThrow();
        Booking booking = bookingMapper.toEntity(bookingDTO , user , flight);
        bookingRepository.save(booking);
        return bookingMapper.toDTO(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getAllBookingsOrdered(){
        return bookingRepository.findAllByOrderByBookingDateDes();
    }

    public Booking getBookingForUser(Long userId, Long bookingId){
        return bookingRepository.findByUserIdAndId(userId , bookingId)
                .orElseThrow(()-> new RuntimeException("Booking not found"));
    }

    public List<Booking> getBookingsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return bookingRepository.findByUser(user);
    }

    public List<Booking> getBookingsByFlight(Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow();
        return bookingRepository.findByFlight(flight);
    }


}
