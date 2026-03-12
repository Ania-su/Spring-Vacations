package org.example.springvacations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Repository
public class BookingRepository {
    private List<Booking> bookings = new ArrayList<>();

    public List<Booking> findAll() {
        return bookings;
    }

    public void save(Booking booking) {
        bookings.add(booking);
    }
}
