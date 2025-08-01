package com.ctw.workstation.team_member.resource;

import com.ctw.workstation.team_member.dto.TeamMemberRequestDTO;
import com.ctw.workstation.team_member.dto.TeamMemberResponseDTO;
import com.ctw.workstation.team_member.service.TeamMemberService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/workstation/team-members")
public class TeamMemberResource {

    @Inject
    TeamMemberService teamMemberService;

    @POST
    public Response createTeamMember(TeamMemberRequestDTO teamMemberRequestDTO){
        TeamMemberResponseDTO teamMemberResponseDTO = teamMemberService.createTeamMember(teamMemberRequestDTO);
        return Response.status(Response.Status.CREATED).entity(teamMemberResponseDTO).build();
    }

    @GET
    public Response getTeamMembers(Long id){
        List<TeamMemberResponseDTO> teamMembers = teamMemberService.getTeamMembers();
        return Response.status(Response.Status.OK).entity(teamMembers).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamMemberById(@PathParam("id") Long id){
        TeamMemberResponseDTO teamMemberResponseDTO = teamMemberService.getTeamMemberById(id);
        return Response.status(Response.Status.OK).entity(teamMemberResponseDTO).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMember(@PathParam("id") Long id, TeamMemberRequestDTO teamMemberRequestDTO){
        TeamMemberResponseDTO teamMemberResponseDTO = teamMemberService.updateTeamMember(id, teamMemberRequestDTO);
        return Response.status(Response.Status.OK).entity(teamMemberResponseDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMember(@PathParam("id") Long id){
        teamMemberService.deleteTeamMember(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
