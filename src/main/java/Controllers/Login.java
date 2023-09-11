package Controllers;


import Commands.LoginCommand;
import Controllers.Contract.ControllerContract;
import Enums.EResponseTypes;
import Handlers.LoginHandler;
import Models.Resident;
import Models.ResponseModel;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Login  {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseModel<Boolean> login(@NotNull LoginCommand command) {
        command.validate();
        if(command.isInvalid()){
            return new ResponseModel<Boolean>(EResponseTypes.InvalidData.toString(), false, null, false);
        }

        LoginHandler handler = new LoginHandler();
        return handler.handle(command);
    }
}
