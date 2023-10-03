package Queries;

import Models.Parcel;
import Repository.ParcelsRepo;
import jakarta.inject.Inject;

import java.util.List;

public class ParcelsQuery {
    @Inject
    ParcelsRepo repo;

    public List<Parcel> getAll(){
        return this.repo.listAll();
    }
    public Parcel getById(int id){
        return this.repo.findById(id);
    }
}
