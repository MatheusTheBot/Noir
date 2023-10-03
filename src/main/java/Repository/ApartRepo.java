package Repository;

import Models.Admin;
import Models.Apart;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ApartRepo implements PanacheRepositoryBase<Apart, Integer> {

    public Apart findByApartAndBlock(int apart, int block){
        return find("Apart=?1 and Block=?2",
                apart , block)
                .firstResult();
    }
    public Optional<Apart> update(Apart product) {
        final var id = product.getId();
        var savedOpt = this.findByIdOptional(id);
        if (savedOpt.isEmpty()) {
            return Optional.empty();
        }

        var saved = savedOpt.get();
        saved.setApart(product.getApart());
        saved.setBuilding(product.getBuilding());

        return Optional.of(saved);
    }
}
