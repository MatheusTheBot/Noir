package Queries;

import Models.Resident;
import Models.Visitor;
import Repository.VisitorsRepo;
import jakarta.inject.Inject;

import java.util.List;

public class VisitorQuery {
    @Inject
    VisitorsRepo repo;

    public List<Visitor> getAll(){
        return this.repo.listAll();
    }
    public Visitor getById(int id){
        return this.repo.findById(id);
    }

    public List<Visitor> getByName(String name){
        return this.repo.getByName(name);
    }
    public List<Visitor> getByEmail(String email){
        return this.repo.getByName(email);
    }
    public List<Visitor> getByDocument(String document){
        return this.repo.getByName(document);
    }
}
