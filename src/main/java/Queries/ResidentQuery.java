package Queries;

import Models.Resident;
import Repository.ResidentRepo;
import jakarta.inject.Inject;

import java.util.List;

public class ResidentQuery {
    @Inject
    ResidentRepo repo;

    public List<Resident> getAll(){
        return this.repo.listAll();
    }
    public Resident getById(int id){
        return this.repo.findById(id);
    }

    public List<Resident> getByName(String name){
        return this.repo.getByName(name);
    }
    public List<Resident> getByEmail(String email){
        return this.repo.getByName(email);
    }
    public List<Resident> getByDocument(String document){
        return this.repo.getByName(document);
    }
}
