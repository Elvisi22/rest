package mapper;

import dto.BookingDTO;
import entity.Booking;
import entity.Flight;
import entity.User;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {
    public  BookingDTO toDTO(Booking booking){
        return new BookingDTO(
                booking.getId(),
                booking.getBookingDate(),
                booking.getStatus(),
                booking.getUser().getId(),
                booking.getFlight().getId()
        );
    }

    public  Booking toEntity(BookingDTO bookingDTO, User user, Flight flight){
        return new Booking(null , bookingDTO.getBookingDate() , bookingDTO.getStatus(), user , flight);
    }
}
