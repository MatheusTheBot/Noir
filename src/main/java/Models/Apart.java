package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "aparts")
public class Apart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int building;
    int apart;
    @OneToMany
    Resident[] residents;
    @OneToMany
    Visitor[] visitors;
    @OneToMany
    Parcel[] parcels;

    public Apart(int id, int apart, int building) {
        this.id = id;
        this.apart = apart;
        this.building = building;
    }
}
