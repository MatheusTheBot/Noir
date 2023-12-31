package Repository;

import Models.Resident;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;


public class ResidentRepo implements PanacheRepositoryBase<Resident, Integer> {
    public Resident loginQuery(String username, String password) {
        return find("username=?1 and password=?2",
                username, password)
                .firstResult();
    }

    public List<Resident> getByName(String name) {
        return find("name like ?1", name).stream().toList();
    }

    public List<Resident> getByEmail(String email) {
        return find("email = ?1", email).stream().toList();
    }

    public List<Resident> getByDocument(String document) {
        return find("document = ?1", document).stream().toList();
    }

    public boolean update(Resident item) {
        final var id = item.getId();
        var toUpdate = this.findById(id);
        if (toUpdate == null) {
            return false;
        }

        toUpdate.setName(item.getName());
        toUpdate.setDocument(item.getDocument());
        toUpdate.setPassword(item.getPassword());
        toUpdate.setUsername(item.getUsername());
        toUpdate.setBirthDate(item.getBirthDate());
        toUpdate.setRole(item.getRole());
        try {
            this.persist(toUpdate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
