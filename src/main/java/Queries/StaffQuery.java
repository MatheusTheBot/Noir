package Queries;

import Models.Resident;
import Models.Staff;
import Repository.StaffRepo;
import jakarta.inject.Inject;

import java.util.List;

public class StaffQuery {

    @Inject
    StaffRepo repo;

    public List<Staff> getAll(){
        return this.repo.listAll();
    }
    public Staff getById(int id){
        return this.repo.findById(id);
    }

    public List<Staff> getByName(String name){
        return this.repo.getByName(name);
    }
    public List<Staff> getByEmail(String email){
        return this.repo.getByName(email);
    }
    public List<Staff> getByDocument(String document){
        return this.repo.getByName(document);
    }
    public List<Staff> getByEmployer(String name){
        return this.repo.getByEmployer(name);
    }
}
