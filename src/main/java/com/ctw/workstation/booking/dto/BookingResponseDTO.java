package com.ctw.workstation.booking.dto;

import java.util.Date;

public record BookingResponseDTO(

        Long id,
        Long rackId,
        Long requesterId,
        Date bookFrom,
        Date bookTo,
        Date createdAt,
        Date modifiedAt
) {}
