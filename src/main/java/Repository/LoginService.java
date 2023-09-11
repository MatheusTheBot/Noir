package Repository;

import Models.Resident;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LoginService {

    @Inject
    EntityManager em;

    @Transactional
    public boolean login(String username, String password){
        Resident urs = new Resident();

        return false;
    }
}
