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
public class CreateOrModifyApartCommand extends Notifiable implements ICommandContract {

    private int id;
    private int building;
    private int apart;

    @Override
    public void validate() {
        Contract contract = new Contract();

        contract
                .requires()
                .isNotNull(id, "id", "Id is required")
                .isGreaterThan(id, 0, "id", "Id must be greater than 0");

        contract
                .requires()
                .isNotNull(building, "building", "Building number is required")
                .isGreaterThan(building, 0, "building", "Building number must be greater than 0");

        contract
                .requires()
                .isNotNull(apart, "apart", "Apartment number is required")
                .isGreaterThan(apart, 0, "apart", "Apartment number must be greater than 0");

        addNotifications(contract);
    }
}
