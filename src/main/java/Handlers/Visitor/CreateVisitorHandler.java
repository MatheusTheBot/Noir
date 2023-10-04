package Handlers.Visitor;

import Commands.CreateOrModifyVisitorCommand;
import Enums.EResponseTypes;
import Handlers.Contract.HandlerContract;
import Models.ResponseModel;
import Models.Visitor;
import Repository.VisitorRepo;
import jakarta.inject.Inject;

public class CreateVisitorHandler implements HandlerContract<ResponseModel<Boolean>, CreateOrModifyVisitorCommand> {
    @Inject
    VisitorRepo repo;

    @Override
    public ResponseModel<Boolean> handle(CreateOrModifyVisitorCommand input) {
        Visitor visitor = new Visitor(
                input.getId(),
                input.getName(),
                input.getDocument(),
                input.getBirthDate(),
                input.isAllowed()
        );

        try {
            repo.persist(visitor);
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
