package com.ctw.workstation.team.dto;

import com.ctw.workstation.team.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
    Team toEntity(TeamRequestDTO teamRequestDTO);
    TeamResponseDTO toDTO(Team team);
    List<TeamResponseDTO> toDTOs(List<Team> teams);

}
