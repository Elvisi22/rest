package dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private LocalDate bookingDate;
    private String status;
    private Long userId;
    private Long flightId;
}