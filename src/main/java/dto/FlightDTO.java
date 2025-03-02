package dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private Long id;
    private String origin;
    private String destination;
    private String airline;
    private String flightNumber;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String status;
}
