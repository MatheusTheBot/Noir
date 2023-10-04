package Repository;

import Models.Staff;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;

public class StaffRepo implements PanacheRepositoryBase<Staff, Integer> {

    public List<Staff> getByName(String name) {
        return find("name like ?1", name).stream().toList();
    }

    public List<Staff> getByEmail(String email) {
        return find("email = ?1", email).stream().toList();
    }

    public List<Staff> getByDocument(String document) {
        return find("document = ?1", document).stream().toList();
    }

    public List<Staff> getByEmployer(String name) {
        return find("employer = ?1", name).stream().toList();
    }

    public boolean update(Staff item) {
        final var id = item.getId();
        var toUpdate = this.findById(id);
        if (toUpdate == null) {
            return false;
        }

        toUpdate.setName(item.getName());
        toUpdate.setDocument(item.getDocument());
        toUpdate.setCanEnter(item.isCanEnter());
        toUpdate.setEmployee(item.getEmployee());
        toUpdate.setBirthDate(item.getBirthDate());
        try {
            this.persist(toUpdate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
