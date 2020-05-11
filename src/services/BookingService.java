package services;

import models.BookingModel;
import repositories.BookingRepository;

import java.util.List;

public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingService(){
        this.bookingRepository = new BookingRepository();
    }

    public List<BookingModel> getAllBooking() {
        return this.bookingRepository.getAllBooking();
    }

    public void deleteBooking(int id) {
        this.bookingRepository.deleteBooking(id);
    }

    public void newBooking(BookingModel booking) {
        this.bookingRepository.newBooking(booking);
    }

    public void updateBooking(BookingModel booking) {
        this.bookingRepository.updateBooking(booking);
    }

}
