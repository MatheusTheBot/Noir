package Commands;

import Commands.Contract.ICommandContract;
import Enums.EParcelTypes;
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
public class CreateOrModifyParcelCommand extends Notifiable implements ICommandContract {

    private int id;
    private EParcelTypes type;
    private String description;
    private Date arrivedDate;
    private String forWho;
    private Date pickedDate;

    @Override
    public void validate() {
        Contract contract = new Contract();

        contract
                .requires()
                .isNotNull(id, "id", "Id is required");

        contract
                .requires()
                .isNotNullOrEmpty(type.name(), "type", "Type is required");

        contract
                .requires()
                .isNotNullOrEmpty(description, "description", "Description is required")
                .hasMinLen(description, 5, "description", "Description must have at least 5 letters");

        contract
                .requires()
                .isNotNull(arrivedDate, "arrivedDate", "Arrived date is required");

        contract
                .requires()
                .isNotNullOrEmpty(forWho, "forWho", "For who is required")
                .hasMinLen(forWho, 3, "forWho", "For who should be at least 3 letters");

        contract
                .requires()
                .isNotNull(pickedDate, "pickedDate", "Picked date is required");

        addNotifications(contract);
    }
}
