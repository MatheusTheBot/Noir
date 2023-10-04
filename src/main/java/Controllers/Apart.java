package Controllers;

import Commands.CreateOrModifyApartCommand;
import Commands.DeleteCommand;
import Enums.EResponseTypes;
import Handlers.Apart.CreateApartHandler;
import Handlers.Apart.DeleteApartHandler;
import Models.ResponseModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/apart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Apart {

    @POST
    public ResponseModel<String> CreateApart(CreateOrModifyApartCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    EResponseTypes.InvalidData.name());
        }

        CreateApartHandler handler = new CreateApartHandler();
        return handler.handle(command);
    }

    @PUT
    public ResponseModel<String> ModifyApart(CreateOrModifyApartCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    EResponseTypes.InvalidData.name());
        }

        CreateApartHandler handler = new CreateApartHandler();
        return handler.handle(command);
    }

    @DELETE
    public ResponseModel<String> DeleteApart(DeleteCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    EResponseTypes.InvalidData.toString()
            );
        }

        DeleteApartHandler handler = new DeleteApartHandler();
        return handler.handle(command);
    }
}
