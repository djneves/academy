package com.ctw.workstation.team.dto;

import java.util.Date;

public record TeamResponseDTO (

        Long id,
        String name,
        String product,
        String defaultLocation,
        Date createdAt,
        Date modifiedAt
){}
