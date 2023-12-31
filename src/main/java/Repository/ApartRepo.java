package Repository;

import Models.Apart;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApartRepo implements PanacheRepositoryBase<Apart, Integer> {

    public Apart findByApartAndBlock(int apart, int block) {
        return find("Apart=?1 and Block=?2",
                apart, block)
                .firstResult();
    }

    public boolean update(Apart item) {
        final var id = item.getId();
        var toUpdate = this.findById(id);
        if (toUpdate == null) {
            return false;
        }

        toUpdate.setApart(item.getApart());
        toUpdate.setBuilding(item.getBuilding());
        try {
            this.persist(toUpdate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
