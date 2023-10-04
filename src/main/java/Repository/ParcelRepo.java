package Repository;

import Models.Parcel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParcelRepo implements PanacheRepositoryBase<Parcel, Integer> {

    public boolean update(Parcel item) {
        final var id = item.getId();
        var toUpdate = this.findById(id);
        if (toUpdate == null) {
            return false;
        }

        toUpdate.setType(item.getType());
        toUpdate.setDescription(item.getDescription());
        toUpdate.setArrivedDate(item.getArrivedDate());
        toUpdate.setPickedDate(item.getPickedDate());
        toUpdate.setForWho(item.getForWho());
        try {
            this.persist(toUpdate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
