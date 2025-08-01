package com.ctw.workstation.team.resource;

import com.ctw.workstation.team.dto.TeamRequestDTO;
import com.ctw.workstation.team.dto.TeamResponseDTO;
import com.ctw.workstation.team.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/workstation/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamService teamService;

    @POST
    public Response createTeam(TeamRequestDTO teamRequestDTO) {
        TeamResponseDTO teamResponseDTO = teamService.createTeam(teamRequestDTO);
        return Response.status(Response.Status.CREATED).entity(teamResponseDTO).build();
    }

    @GET
    public Response getTeams(){
        List<TeamResponseDTO> teams = teamService.getTeams();
        if(teams.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(teams).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") Long id){
        TeamResponseDTO teamResponseDTO = teamService.getTeamById(id);
        return Response.status(Response.Status.OK).entity(teamResponseDTO).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") Long id, TeamRequestDTO teamRequestDTO){
        TeamResponseDTO teamResponseDTO = teamService.updateTeam(id, teamRequestDTO);
        return Response.status(Response.Status.OK).entity(teamResponseDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") Long id){
        teamService.deleteTeam(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
