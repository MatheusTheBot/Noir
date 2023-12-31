package Controllers;

import Commands.CreateOrModifyResidentCommand;
import Commands.DeleteCommand;
import Enums.EResponseTypes;
import Handlers.Resident.CreateResidentHandler;
import Handlers.Resident.DeleteResidentHandler;
import Handlers.Resident.ModifyResidentHandler;
import Models.ResponseModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/resident")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Resident {
    @POST
    public ResponseModel<Boolean> CreateResident(CreateOrModifyResidentCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    null
            );
        }

        CreateResidentHandler handler = new CreateResidentHandler();
        return handler.handle(command);
    }

    @PUT
    public ResponseModel<Boolean> ModifyResident(CreateOrModifyResidentCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    null
            );
        }

        ModifyResidentHandler handler = new ModifyResidentHandler();
        return handler.handle(command);
    }

    @DELETE
    public ResponseModel<String> DeleteResident(DeleteCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    EResponseTypes.InvalidData.name()
            );
        }

        DeleteResidentHandler handler = new DeleteResidentHandler();
        return handler.handle(command);
    }
}
