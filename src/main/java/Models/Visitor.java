package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String document;
    Date birthDate;
    boolean isAllowed;
    @ManyToOne
    Apart apart;

    public Visitor(int id, String name, String document, Date birthDate, Boolean isAllowed) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.isAllowed = isAllowed;

    }
}
