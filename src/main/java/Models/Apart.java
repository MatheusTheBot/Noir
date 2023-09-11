package Models;

import Models.Contracts.ModelContract;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aparts")
public class Apart{
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
}
