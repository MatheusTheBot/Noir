package Models.Contracts;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ModelContract {
    //when a class is instantiated and extends from this abstract class
    //it creates an id field and generates an id, or at least should...

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
}
