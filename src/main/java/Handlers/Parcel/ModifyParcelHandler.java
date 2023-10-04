package Handlers.Parcel;

import Commands.CreateOrModifyParcelCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Parcel;
import Models.ResponseModel;
import Repository.ParcelRepo;
import jakarta.inject.Inject;

public class ModifyParcelHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyParcelCommand> {
    @Inject
    ParcelRepo repo;

    @Override
    public ResponseModel<Boolean> handle(CreateOrModifyParcelCommand input) {
        Parcel parcel = new Parcel(
                input.getId(),
                input.getType(),
                input.getDescription(),
                input.getArrivedDate(),
                input.getForWho(),
                input.getPickedDate()
        );

        boolean response;

        response = repo.update(parcel);

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