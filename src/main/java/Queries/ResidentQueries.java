package Queries;

import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;

import javax.persistence.EntityManager;

public class ResidentQueries {

    @PersistenceContext
    @Inject
    EntityManager em;

    public Object loginQuery(String username, String password){
        return em.createQuery("Select * from residents where username=?1 and password=?2")
                .setParameter(1, username)
                .setParameter(2, password)
                .getSingleResult();
    }
}
