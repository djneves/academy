package com.ctw.workstation.team.dto;

import java.util.Date;

public record TeamRequestDTO (

        String name,
        String product,
        String defaultLocation,
        Date createdAt,
        Date modifiedAt
){}
