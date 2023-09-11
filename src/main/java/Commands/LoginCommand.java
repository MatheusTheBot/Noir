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
@AllArgsConstructor
@NoArgsConstructor
public class LoginCommand extends Notifiable implements ICommandContract  {
    String username;
    String password;

    @Override
    public void validate() {
        Contract contract = new Contract();

        contract
                .requires()
                .isNotNullOrEmpty(username, "username", "Username is required")
                .hasMinLen(username, 5, "username", "Username must have at least 5 characters");

        contract
                .requires()
                .isNotNullOrEmpty(password, "password", "Password is required")
                .hasMinLen(password, 8, "password", "Password must have at least 8 characters");

        addNotifications(contract);
    }
}
