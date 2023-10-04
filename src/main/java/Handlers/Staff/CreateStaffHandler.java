package Handlers.Staff;

import Commands.CreateOrModifyStaffCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.ResponseModel;
import Models.Staff;
import Repository.StaffRepo;
import jakarta.inject.Inject;

public class CreateStaffHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyStaffCommand> {
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

        try {
            repo.persist(staff);
        } catch (Exception e) {
            return new ResponseModel<>(
                    input.toString(),
                    false,
                    new String[]{EResponseTypes.PersistanceError.name()},
                    null
            );
        } finally {
            repo.flush();
        }
        return new ResponseModel<>(
                input.toString(),
                true,
                new String[]{EResponseTypes.ValidQuery.name()},
                null
        );
    }
}