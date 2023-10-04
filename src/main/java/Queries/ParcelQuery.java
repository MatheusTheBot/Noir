package Queries;

import Models.Parcel;
import Repository.ParcelRepo;
import jakarta.inject.Inject;

import java.util.List;

public class ParcelQuery {
    @Inject
    ParcelRepo repo;

    public List<Parcel> getAll() {
        return this.repo.listAll();
    }

    public Parcel getById(int id) {
        return this.repo.findById(id);
    }
}
