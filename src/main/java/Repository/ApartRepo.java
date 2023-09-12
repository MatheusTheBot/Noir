package Repository;

import Models.Apart;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApartRepo implements PanacheRepositoryBase<Apart, Integer> {

}
