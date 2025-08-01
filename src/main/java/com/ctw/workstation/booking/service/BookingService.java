package com.ctw.workstation.booking.service;

import com.ctw.workstation.booking.dto.BookingMapper;
import com.ctw.workstation.booking.dto.BookingRequestDTO;
import com.ctw.workstation.booking.dto.BookingResponseDTO;
import com.ctw.workstation.booking.entity.Booking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository bookingRepository;
    @Inject
    BookingMapper bookingMapper;

    @Transactional
    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        Booking booking = bookingMapper.toEntity(bookingRequestDTO);
        bookingRepository.persist(booking);
        return bookingMapper.toDTO(booking);
    }

    public List<BookingResponseDTO> getBookings() {
        return bookingRepository.listAll().stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingResponseDTO getBookingById(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findByIdOptional(id);
        if (bookingOptional.isPresent())
            return bookingMapper.toDTO(bookingOptional.get());
        else
            throw new RuntimeException("Booking not found");
    }

    @Transactional
    public void deleteBooking(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findByIdOptional(id);
        if (bookingOptional.isPresent())
            bookingRepository.delete(bookingOptional.get());
        else
            throw new RuntimeException("Booking not found");
    }
}
