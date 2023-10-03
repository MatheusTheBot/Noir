package Handlers;

import Commands.CreateOrModifyApartCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Apart;
import Models.ResponseModel;
import Repository.ApartRepo;
import jakarta.inject.Inject;

import java.util.Optional;

public class ModifyApartHandler  implements HandlerContract<ResponseModel<Apart>, CreateOrModifyApartCommand> {
    @Inject
    ApartRepo repo;

    @Override
    public ResponseModel<Apart> handle(CreateOrModifyApartCommand input){
        Apart apart = new Apart(input.getId(), input.getApart(), input.getBuilding());

        Optional<Apart> response;

        try {
            response = repo.update(apart);
        }
        catch (Exception e){
            return new ResponseModel<>(
                    input.toString(),
                    false,
                    new String[] {EResponseTypes.PersistanceError.name()},
                    null
            );
        }
        finally {
            repo.flush();
        }
        return new ResponseModel<>(
                input.toString(),
                true,
                new String[] {EResponseTypes.ValidQuery.name()},
                response.orElse(null)
        );
    }
}