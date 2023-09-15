package Handlers;

import Commands.LoginCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Admin;
import Models.Resident;
import Models.ResponseModel;
import Repository.AdminRepo;
import Repository.ResidentRepo;

public class LoginHandler implements HandlerContract<ResponseModel<String>, LoginCommand> {

    @Override
    public ResponseModel<String> handle(LoginCommand input) {
        //FIXME: probably i should inject the repo instead of instantiate it

        String response = "";

        Admin response1 = new AdminRepo().loginQuery(input.getUsername(), input.getPassword());
        Resident response2 = new ResidentRepo().loginQuery(input.getUsername(), input.getPassword());

        if(response1 == null && response2 == null){
            return new ResponseModel<>(input.toString(),
                    false, new String[] {EResponseTypes.NullQuery.name()}, "");
        }

        if(response1 != null){
            response = "Admin";
        }
        else {
            response = "User";
        }

        return new ResponseModel<>(input.toString(),true, EResponseTypes.ValidQuery.name().split(","), response);
    }
}
