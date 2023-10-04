package Handlers.Visitor;

import Commands.DeleteCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.ResponseModel;
import Repository.VisitorRepo;
import jakarta.inject.Inject;

public class DeleteVisitorHandler implements HandlerContract<ResponseModel<String>, DeleteCommand> {
    @Inject
    VisitorRepo repo;

    @Override
    public ResponseModel<String> handle(DeleteCommand input) {
        boolean response;
        try {
            response = repo.deleteById(input.getId());
        } catch (Exception e) {
            return new ResponseModel<>(
                    input.toString(),
                    false,
                    new String[]{EResponseTypes.PersistanceError.name()},
                    "");
        }

        if (!response) {
            return new ResponseModel<>(
                    input.toString(),
                    false,
                    new String[]{EResponseTypes.ValidQuery.name()},
                    "");
        } else return new ResponseModel<>(
                input.toString(),
                true,
                new String[]{EResponseTypes.ValidQuery.name()},
                "");
    }
}