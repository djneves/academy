package com.ctw.workstation.team_member.service;


import com.ctw.workstation.team_member.dto.TeamMemberMapper;
import com.ctw.workstation.team_member.dto.TeamMemberRequestDTO;
import com.ctw.workstation.team_member.dto.TeamMemberResponseDTO;
import com.ctw.workstation.team_member.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamMemberRepository teamMemberRepository;
    @Inject
    TeamMemberMapper teamMemberMapper;

    @Transactional
    public TeamMemberResponseDTO createTeamMember(TeamMemberRequestDTO teamMemberRequestDTO){
        TeamMember teamMember = teamMemberMapper.toEntity(teamMemberRequestDTO);
        teamMemberRepository.persist(teamMember);
        return teamMemberMapper.toDTO(teamMember);
    }

    public List<TeamMemberResponseDTO> getTeamMembers(){
        return teamMemberRepository.streamAll()
                .map(teamMemberMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TeamMemberResponseDTO getTeamMemberById(Long id){
        Optional<TeamMember> teamMemberOptional = teamMemberRepository.findByIdOptional(id);
        if (teamMemberOptional.isPresent())
            return teamMemberMapper.toDTO(teamMemberOptional.get());
        else
            throw new RuntimeException("Team Member not found");
    }

    @Transactional
    public TeamMemberResponseDTO updateTeamMember(Long id, TeamMemberRequestDTO teamMemberRequestDTO){
        Optional<TeamMember> teamMemberOptional = teamMemberRepository.findByIdOptional(id);
        if (teamMemberOptional.isPresent()) {
            TeamMember teamMember = teamMemberOptional.get();
            teamMember.name = teamMemberRequestDTO.name();
            teamMember.teamId = teamMemberRequestDTO.teamId();
            return teamMemberMapper.toDTO(teamMember);
        } else
            throw new RuntimeException("Team Member not found");
    }

    @Transactional
    public void deleteTeamMember(Long id){
        Optional<TeamMember> teamMemberOptional = teamMemberRepository.findByIdOptional(id);
        if (teamMemberOptional.isPresent())
            teamMemberRepository.delete(teamMemberOptional.get());
        else
            throw new RuntimeException("Team Member not found");
    }
}
