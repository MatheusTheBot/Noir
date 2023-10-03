package Commands;

import Commands.Contract.ICommandContract;
import Enums.EParcelTypes;
import jflunt.notifications.Notifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateParcelCommand extends Notifiable implements ICommandContract {

    int id;
    EParcelTypes type;
    String description;
    Date arrivedDate;
    String forWho;

    @Override
    public void validate() {
        //TODO: implement
    }
}
