package org.example.springvacations;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Data

@RestController
public class BookingController {

    private final BookingService service;


    @GetMapping("/booking")
    public List<Booking> getBookings() {
        return service.getAllBookings();
    }

    @PostMapping("/booking")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {

        try {
            List<Booking> bookings = service.addBooking(booking);
            return ResponseEntity.ok(bookings);
        } catch (RuntimeException e) {

            if (e.getMessage().contains("between 1 and 9")) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
