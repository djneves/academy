package com.ctw.workstation.team_member.dto;

import com.ctw.workstation.team_member.entity.TeamMember;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMemberMapper {
    TeamMemberMapper INSTANCE = Mappers.getMapper(TeamMemberMapper.class);
    TeamMember toEntity(TeamMemberRequestDTO  teamMemberRequestDTO);
    TeamMemberResponseDTO toDTO(TeamMember teamMember);
    List<TeamMemberResponseDTO> toDTOs(List<TeamMember> teamMembers);
}
