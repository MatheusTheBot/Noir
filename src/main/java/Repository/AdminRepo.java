package Repository;

import Models.Admin;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;



public class AdminRepo implements PanacheRepositoryBase<Admin, Integer> {
    public Admin loginQuery(String username, String password){
        return find("username=?1 and password=?2",
                username , password)
                .firstResult();
    }
}
