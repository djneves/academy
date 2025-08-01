package com.ctw.workstation.team_member.dto;

import java.util.Date;

public record TeamMemberResponseDTO(

        Long id,
        String ctwId,
        String name,
        Long teamId,
        Date createdAt,
        Date modifiedAt
) {}
