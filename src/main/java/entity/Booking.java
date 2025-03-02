package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id" , referencedColumnName = "id")
    private Flight flight;
}

