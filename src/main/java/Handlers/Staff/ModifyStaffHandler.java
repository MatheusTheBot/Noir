package Handlers.Staff;

import Commands.CreateOrModifyStaffCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.ResponseModel;
import Models.Staff;
import Repository.StaffRepo;
import jakarta.inject.Inject;

public class ModifyStaffHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyStaffCommand> {
    @Inject
    StaffRepo repo;

    @Override
    public ResponseModel<Boolean> handle(CreateOrModifyStaffCommand input) {
        Staff staff = new Staff(
                input.getId(),
                input.getName(),
                input.getDocument(),
                input.getBirthDate(),
                input.getEmployee(),
                input.isCanEnter()
        );

        boolean response;

        response = repo.update(staff);

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