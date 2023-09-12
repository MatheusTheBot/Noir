package Repository;

import Models.Resident;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;


public class ResidentRepo implements PanacheRepositoryBase<Resident, Integer> {
    public Resident loginQuery(String username, String password){
        return find("username=?1 and password=?2",
                username, password)
                .firstResult();
    }
}
