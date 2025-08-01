package com.ctw.workstation.rack_asset.resource;


import com.ctw.workstation.rack_asset.dto.RackAssetRequestDTO;
import com.ctw.workstation.rack_asset.dto.RackAssetResponseDTO;
import com.ctw.workstation.rack_asset.service.RackAssetService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/workstation/rack-assets")
public class RackAssetResource {

    @Inject
    RackAssetService rackAssetService;

    @POST
    public Response createRack(RackAssetRequestDTO rackAssetRequestDTO){
        RackAssetResponseDTO rackAssetResponseDTO = rackAssetService.createRackAsset(rackAssetRequestDTO);
        return Response.status(Response.Status.CREATED).entity(rackAssetResponseDTO).build();
    }

    @GET
    public Response getRackAssets(){
        List<RackAssetResponseDTO> rackAssets = rackAssetService.getRackAssets();
        return Response.status(Response.Status.OK).entity(rackAssets).build();
    }

    @GET
    @Path("/{id}")
    public Response getRackAssetById(@PathParam("id") Long id){
        RackAssetResponseDTO rackAssetResponseDTO = rackAssetService.getRackAssetById(id);
        return Response.status(Response.Status.OK).entity(rackAssetResponseDTO).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRackAsset(@PathParam("id") Long id, RackAssetRequestDTO rackAssetRequestDTO){
        RackAssetResponseDTO rackAssetResponseDTO = rackAssetService.updateRackAsset(id, rackAssetRequestDTO);
        return Response.status(Response.Status.OK).entity(rackAssetResponseDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackAsset(@PathParam("id") Long id){
        rackAssetService.deleteRackAsset(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
