package com.ctw.workstation.rack.dto;

import com.ctw.workstation.Status;
import java.util.Date;

public record RackResponseDTO(

        Long id,
        String serialNumber,
        Status status,
        Long teamId,
        String defaultLocation,
        Date assembledAt,
        Date createdAt,
        Date modifiedAt
) {}
