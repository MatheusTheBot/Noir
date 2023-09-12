package Repository;

import Models.Parcel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParcelsRepo implements PanacheRepositoryBase<Parcel, Integer> {

}
