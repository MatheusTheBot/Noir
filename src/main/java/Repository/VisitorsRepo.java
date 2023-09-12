package Repository;

import Models.Visitor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisitorsRepo implements PanacheRepositoryBase<Visitor, Integer> {

}
