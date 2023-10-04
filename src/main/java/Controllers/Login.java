package Controllers;


import Commands.LoginCommand;
import Enums.EResponseTypes;
import Handlers.LoginHandler;
import Models.ResponseModel;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Login {

    @POST
    public ResponseModel<String> login(LoginCommand command) {
        command.validate();
        if (command.isInvalid()) {
            return new ResponseModel<>(command.toString(), false, command.getNotifications().toArray(), EResponseTypes.InvalidData.toString());
        }

        LoginHandler handler = new LoginHandler();
        return handler.handle(command);
    }
}
