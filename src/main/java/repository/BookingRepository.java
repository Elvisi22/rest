package repository;

import entity.Booking;
import entity.Flight;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByUserIdAndId(Long userId , Long bookingId);
    List<Booking> findByFlightId(Long flightId);
    List<Booking> findAllByOrderByBookingDateDes();
    List<Booking> findByUser(User user);
    List<Booking> findByFlight(Flight flight);
}

