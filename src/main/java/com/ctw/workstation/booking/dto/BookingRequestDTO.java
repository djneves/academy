package com.ctw.workstation.booking.dto;

import java.util.Date;

public record BookingRequestDTO(

        Long rackId,
        Long requesterId,
        Date bookFrom,
        Date bookTo,
        Date createdAt,
        Date modifiedAt
) {}
