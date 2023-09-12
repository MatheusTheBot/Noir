package Controllers;


import Commands.LoginCommand;
import Enums.EResponseTypes;
import Handlers.LoginHandler;
import Models.ResponseModel;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Login  {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseModel<Boolean> login(LoginCommand command) {
        command.validate();
        if(command.isInvalid()){
            return new ResponseModel<>(EResponseTypes.InvalidData.toString(), false, null, false);
        }

        LoginHandler handler = new LoginHandler();
        return handler.handle(command);
    }
}
