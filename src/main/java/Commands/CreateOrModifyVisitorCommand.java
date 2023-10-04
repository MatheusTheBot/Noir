package Commands;

import Commands.Contract.ICommandContract;
import jflunt.notifications.Notifiable;
import jflunt.validations.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrModifyVisitorCommand extends Notifiable implements ICommandContract {

    private int id;
    private String name;
    private String document;
    private Date birthDate;
    private boolean isAllowed;

    @Override
    public void validate() {
        Contract contract = new Contract();

        contract
                .requires()
                .isNotNull(id, "id", "Id is required");

        contract
                .requires()
                .isNotNullOrEmpty(name, "name", "Name is required")
                .hasMinLen(name, 3, "name", "Name needs to have at least 3 letters");

        contract
                .requires()
                .isNotNullOrEmpty(document, "document", "Document must not be empty")
                .isBetween(document.length(), 11, 14, "document", "Document must be like ###.###.###-## or ###########");

        contract
                .requires()
                .isNotNull(birthDate, "birthDate", "Birth date is required");

        // Assuming isAllowed should always be provided
        contract
                .requires()
                .isNotNull(isAllowed, "isAllowed", "Permission status is required");

        addNotifications(contract);
    }
}
