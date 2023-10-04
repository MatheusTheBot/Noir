package Models;

import Enums.ERole;
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
@Table(name = "residents")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String username;
    String password;
    String document;
    Date birthDate;
    ERole role;
    @ManyToOne
    Apart apart;

    public Resident(int id, String name, String username, String password, String document, Date birthDate, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.document = document;
        this.birthDate = birthDate;
        this.role = ERole.valueOf(role);
    }
}