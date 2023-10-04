package Controllers;

import Commands.CreateOrModifyStaffCommand;
import Commands.DeleteCommand;
import Enums.EResponseTypes;
import Handlers.Staff.CreateStaffHandler;
import Handlers.Staff.DeleteStaffHandler;
import Handlers.Staff.ModifyStaffHandler;
import Models.ResponseModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/staff")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Staff {

    @POST
    public ResponseModel<Boolean> CreateResident(CreateOrModifyStaffCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    null
            );
        }

        CreateStaffHandler handler = new CreateStaffHandler();
        return handler.handle(command);
    }

    @PUT
    public ResponseModel<Boolean> ModifyResident(CreateOrModifyStaffCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    null
            );
        }

        ModifyStaffHandler handler = new ModifyStaffHandler();
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

        DeleteStaffHandler handler = new DeleteStaffHandler();
        return handler.handle(command);
    }
}
