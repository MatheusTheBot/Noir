package Commands;

import Commands.Contract.ICommandContract;
import jflunt.notifications.Notifiable;
import jflunt.validations.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCommand extends Notifiable implements ICommandContract {

    private int id;

    @Override
    public void validate() {
        Contract contract = new Contract();

        contract
                .requires()
                .isNotNull(id, "id", "Id is required");

        addNotifications(contract);
    }
}
