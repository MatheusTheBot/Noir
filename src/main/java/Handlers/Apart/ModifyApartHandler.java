package Handlers.Apart;

import Commands.CreateOrModifyApartCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Apart;
import Models.ResponseModel;
import Repository.ApartRepo;
import jakarta.inject.Inject;

public class ModifyApartHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyApartCommand> {
    @Inject
    ApartRepo repo;

    @Override
    public ResponseModel<Boolean> handle(CreateOrModifyApartCommand input) {
        Apart apart = new Apart(input.getId(), input.getApart(), input.getBuilding());

        boolean response;

        response = repo.update(apart);

        if (!response) {
            return new ResponseModel<>(
                    input.toString(),
                    false,
                    new String[]{EResponseTypes.PersistanceError.name()},
                    null
            );
        }

        repo.flush();

        return new ResponseModel<>(
                input.toString(),
                true,
                new String[]{EResponseTypes.ValidQuery.name()},
                null
        );
    }
}