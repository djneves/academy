package com.ctw.workstation.rack.resource;


import com.ctw.workstation.rack.dto.RackRequestDTO;
import com.ctw.workstation.rack.dto.RackResponseDTO;
import com.ctw.workstation.rack.service.RackService;
import com.ctw.workstation.team.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/workstation/racks")
public class RackResource {

    @Inject
    RackService rackService;

    @POST
    public Response createRack(RackRequestDTO rackRequestDTO) {
        RackResponseDTO rackResponseDTO = rackService.createRack(rackRequestDTO);
        return Response.status(Response.Status.CREATED).entity(rackResponseDTO).build();
    }

    @GET
    public Response getRacks(){
        List<RackResponseDTO> racks = rackService.getRacks();
        return Response.status(Response.Status.OK).entity(racks).build();
    }

    @GET
    @Path("/{id}")
    public Response getRackById(@PathParam("id") Long id){
        RackResponseDTO rackResponseDTO = rackService.getRackById(id);
        return Response.status(Response.Status.OK).entity(rackResponseDTO).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRack(@PathParam("id") Long id, RackRequestDTO rackRequestDTO){
        RackResponseDTO rackResponseDTO = rackService.updateRack(id, rackRequestDTO);
        return Response.status(Response.Status.OK).entity(rackResponseDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") Long id){
        rackService.deleteRack(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
