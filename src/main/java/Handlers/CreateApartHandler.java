package Handlers;

import Commands.CreateOrModifyApartCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Apart;
import Models.ResponseModel;
import Repository.ApartRepo;
import jakarta.inject.Inject;

public class CreateApartHandler implements HandlerContract<ResponseModel<String>, CreateOrModifyApartCommand> {
    @Inject ApartRepo repo;

    @Override
    public ResponseModel<String> handle(CreateOrModifyApartCommand input){
            Apart apart = new Apart(input.getId(), input.getApart(), input.getBuilding());

            try {
                repo.persist(apart);
            }
            catch (Exception e){
                return new ResponseModel<>(
                        input.toString(),
                        false,
                        new String[] {EResponseTypes.PersistanceError.name()},
                        e.getMessage()
                );
            }
            finally {
                repo.flush();
            }
            return new ResponseModel<>(
                    input.toString(),
                    true,
                    new String[] {EResponseTypes.ValidQuery.name()},
                    ""
            );
    }
}