package net.higility.vehicle.business.vehicle.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.higility.vehicle.business.vehicle.control.VehicleRepository;
import net.higility.vehicle.business.vehicle.entity.Vehicle;

import java.util.List;

@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {
    @Inject
    VehicleRepository vehicleRepository;

    @GET
    public List<Vehicle> listAll() {
        return vehicleRepository.listAll();
    }

}
