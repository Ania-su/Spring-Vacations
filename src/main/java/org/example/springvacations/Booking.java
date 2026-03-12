package org.example.springvacations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Booking {
    private String clientName;
    private String phoneNumber;
    private String email;
    private int roomNumber;
    private String roomDescription;
    private LocalDate reservationDate;
}
