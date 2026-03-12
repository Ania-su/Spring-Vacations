package org.example.springvacations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingService {
    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public List<Booking> addBooking(Booking booking) {

        if (booking.getRoomNumber() < 1 || booking.getRoomNumber() > 9) {
            throw new RuntimeException("Room number must be between 1 and 9");
        }

        for (Booking b : repository.findAll()) {

            if (b.getRoomNumber() == booking.getRoomNumber()
                    && b.getReservationDate().equals(booking.getReservationDate())) {

                throw new RuntimeException("Room already booked for this date");
            }
        }

        repository.save(booking);

        return repository.findAll();
    }
}
