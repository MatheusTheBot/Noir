package Handlers.Parcel;

import Commands.CreateOrModifyParcelCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.Parcel;
import Models.ResponseModel;
import Repository.ParcelRepo;
import jakarta.inject.Inject;

public class CreateParcelHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyParcelCommand> {
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

        try {
            repo.persist(parcel);
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