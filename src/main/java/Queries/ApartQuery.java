package Queries;

import Models.Apart;
import Repository.ApartRepo;
import jakarta.inject.Inject;

import java.util.List;

public class ApartQuery {

    @Inject
    ApartRepo repo;

    public List<Apart> getAll() {
        return this.repo.listAll();
    }

    public Apart getById(int id) {
        return this.repo.findById(id);
    }

    public Apart getByApartNumbers(int apart, int block) {
        return this.repo.findByApartAndBlock(apart, block);
    }
}