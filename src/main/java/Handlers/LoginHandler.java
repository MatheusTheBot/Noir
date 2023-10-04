package Handlers;

import Commands.LoginCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Admin;
import Models.Resident;
import Models.ResponseModel;
import Repository.AdminRepo;
import Repository.ResidentRepo;
import jakarta.inject.Inject;

public class LoginHandler implements HandlerContract<ResponseModel<String>, LoginCommand> {

    @Inject
    AdminRepo admin;

    @Inject
    ResidentRepo resident;

    @Override
    public ResponseModel<String> handle(LoginCommand input) {
        String response = "";

        Admin response1 = admin.loginQuery(input.getUsername(), input.getPassword());
        Resident response2 = resident.loginQuery(input.getUsername(), input.getPassword());

        if (response1 == null && response2 == null) {
            return new ResponseModel<>(input.toString(),
                    false, new String[]{EResponseTypes.NullQuery.name()}, "");
        }

        if (response1 != null) {
            response = "Admin";
        } else {
            response = "User";
        }

        return new ResponseModel<>(input.toString(), true, EResponseTypes.ValidQuery.name().split(","), response);
    }
}
