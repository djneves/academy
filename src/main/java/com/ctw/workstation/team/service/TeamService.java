package com.ctw.workstation.team.service;

import com.ctw.workstation.team.dto.TeamMapper;
import com.ctw.workstation.team.dto.TeamRequestDTO;
import com.ctw.workstation.team.dto.TeamResponseDTO;
import com.ctw.workstation.team.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository teamRepository;
    @Inject
    TeamMapper teamMapper;

    @Transactional
    public TeamResponseDTO createTeam(TeamRequestDTO teamRequestDTO) {
        Team team = teamMapper.toEntity(teamRequestDTO);
        teamRepository.persist(team);
        return teamMapper.toDTO(team);
    }

    public List<TeamResponseDTO> getTeams() {
        return teamRepository.streamAll()
                .map(teamMapper::toDTO)
                .toList();
    }

    //@Transactional
    public TeamResponseDTO getTeamById(Long id) {
        Optional<Team> teamOptional = teamRepository.findByIdOptional(id);
        if (teamOptional.isPresent())
            return teamMapper.toDTO(teamOptional.get());
        else
            throw new RuntimeException("Team not found");
    }

    @Transactional
    public TeamResponseDTO updateTeam(Long id, TeamRequestDTO teamRequestDTO) {
        Optional<Team> teamOptional = teamRepository.findByIdOptional(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            team.name = teamRequestDTO.name();
            team.product = teamRequestDTO.product();
            return teamMapper.toDTO(team);
        } else
            throw new RuntimeException("Team not found");
    }

    @Transactional
    public void deleteTeam(Long id) {
        Optional<Team> teamOptional = teamRepository.findByIdOptional(id);
        if (teamOptional.isPresent())
            teamRepository.delete(teamOptional.get());
        else
            throw new RuntimeException("Team not found");
    }
}
