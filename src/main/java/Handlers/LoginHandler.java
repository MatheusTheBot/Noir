package Handlers;

import Commands.LoginCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Admin;
import Models.Resident;
import Models.ResponseModel;
import Repository.AdminRepo;
import Repository.ResidentRepo;

public class LoginHandler implements HandlerContract<ResponseModel<Boolean>, LoginCommand> {

    @Override
    public ResponseModel<Boolean> handle(LoginCommand input) {
        //FIXME: probably i should inject the repo instead of instantiate it

        Admin response1 = new AdminRepo().loginQuery(input.getUsername(), input.getPassword());
        Resident response2 = new ResidentRepo().loginQuery(input.getUsername(), input.getPassword());

        if(response1 == null && response2 == null){
            return new ResponseModel<>(input.toString(),
                    false, new String[] {EResponseTypes.NullQuery.name()}, false);
        }

        return new ResponseModel<>(input.toString(),
                true, new String[] {EResponseTypes.ValidQuery.name()}, true);
    }
}
