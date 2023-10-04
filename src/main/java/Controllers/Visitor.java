package Controllers;

import Commands.CreateOrModifyVisitorCommand;
import Commands.DeleteCommand;
import Enums.EResponseTypes;
import Handlers.Visitor.CreateVisitorHandler;
import Handlers.Visitor.DeleteVisitorHandler;
import Handlers.Visitor.ModifyVisitorHandler;
import Models.ResponseModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/visitors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Visitor {
    @POST
    public ResponseModel<Boolean> CreateVisitor(CreateOrModifyVisitorCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    null
            );
        }

        CreateVisitorHandler handler = new CreateVisitorHandler();
        return handler.handle(command);
    }

    @PUT
    public ResponseModel<Boolean> ModifyVisitor(CreateOrModifyVisitorCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    null
            );
        }

        ModifyVisitorHandler handler = new ModifyVisitorHandler();
        return handler.handle(command);
    }

    @DELETE
    public ResponseModel<String> DeleteVisitor(DeleteCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(
                    command.toString(),
                    false,
                    command.getNotifications().toArray(),
                    EResponseTypes.InvalidData.name()
            );
        }

        DeleteVisitorHandler handler = new DeleteVisitorHandler();
        return handler.handle(command);
    }
}
