package Handlers.Resident;

import Commands.CreateOrModifyResidentCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Resident;
import Models.ResponseModel;
import Repository.ResidentRepo;
import jakarta.inject.Inject;

public class ModifyResidentHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyResidentCommand> {
    @Inject
    ResidentRepo repo;

    @Override
    public ResponseModel<Boolean> handle(CreateOrModifyResidentCommand input) {
        Resident resident = new Resident(
                input.getId(),
                input.getName(),
                input.getUsername(),
                input.getPassword(),
                input.getDocument(),
                input.getBirthDate(),
                input.getRole()
        );

        boolean response;

        response = repo.update(resident);
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