package Handlers;

import Commands.LoginCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.ResponseModel;
import Queries.AdminQueries;
import Queries.ResidentQueries;

public class LoginHandler implements HandlerContract<ResponseModel<Boolean>, LoginCommand> {

    @Override
    public ResponseModel<Boolean> handle(LoginCommand input) {
        Object response1 = new AdminQueries().loginQuery(input.getUsername(), input.getPassword());
        Object response2 = new ResidentQueries().loginQuery(input.getUsername(), input.getPassword());

        if(response1 == null && response2 == null){
            return new ResponseModel<>(EResponseTypes.NullQuery.name(),
                    false, null, false);
        }

    }
}
