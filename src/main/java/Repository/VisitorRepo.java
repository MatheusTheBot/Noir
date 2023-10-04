package Repository;

import Models.Visitor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class VisitorRepo implements PanacheRepositoryBase<Visitor, Integer> {

    public List<Visitor> getByName(String name) {
        return find("name like ?1", name).stream().toList();
    }

    public List<Visitor> getByEmail(String email) {
        return find("email = ?1", email).stream().toList();
    }

    public List<Visitor> getByDocument(String document) {
        return find("document = ?1", document).stream().toList();
    }

    public boolean update(Visitor item) {
        final var id = item.getId();
        var toUpdate = this.findById(id);
        if (toUpdate == null) {
            return false;
        }

        toUpdate.setName(item.getName());
        toUpdate.setDocument(item.getDocument());
        toUpdate.setBirthDate(item.getBirthDate());
        toUpdate.setAllowed(item.isAllowed());
        try {
            this.persist(toUpdate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
