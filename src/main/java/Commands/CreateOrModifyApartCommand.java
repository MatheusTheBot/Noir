package Commands;

import Commands.Contract.ICommandContract;
import jflunt.notifications.Notifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrModifyApartCommand extends Notifiable implements ICommandContract {

    int id;
    int building;
    int apart;


    @Override
    public void validate() {
        //TODO: implement
    }
}

