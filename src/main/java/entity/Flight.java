package entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private String airline;
    private String flightNumber;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String status;

    @OneToMany(mappedBy = "flight" , cascade = CascadeType.ALL)
    private List<Booking> bookings;
}

