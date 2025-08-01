package com.ctw.workstation.booking.resource;

import com.ctw.workstation.booking.dto.BookingRequestDTO;
import com.ctw.workstation.booking.dto.BookingResponseDTO;
import com.ctw.workstation.booking.service.BookingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/workstation/bookings")
public class BookingResource {

    @Inject
    BookingService bookingService;

    @POST
    public Response createBooking(BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.createBooking(bookingRequestDTO);
        return Response.status(Response.Status.CREATED).entity(bookingResponseDTO).build();
    }

    @GET
    public Response getBookings() {
        List<BookingResponseDTO> bookings = bookingService.getBookings();
        return Response.status(Response.Status.OK).entity(bookings).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookingById(@PathParam("id") Long id) {
        BookingResponseDTO bookingResponseDTO = bookingService.getBookingById(id);
        return Response.status(Response.Status.OK).entity(bookingResponseDTO).build();
    }

    /**
    @PUT
    @Path("/{id}")
    public Response updateBooking(@PathParam("id") Long id, BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.up
    }**/

    @DELETE
    @Path("/{id}")
    public Response deleteBookingById(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
