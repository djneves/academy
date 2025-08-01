package com.ctw.workstation.booking.dto;

import com.ctw.workstation.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
    BookingResponseDTO toDTO(Booking booking);
    Booking toEntity(BookingRequestDTO  bookingRequestDTO);
    List<BookingResponseDTO> toDTOs(List<Booking> bookings);
}
