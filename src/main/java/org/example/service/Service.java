package org.example.service;

import org.example.Domain.Angajat;
import org.example.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private  Repository repositoryAngajat;

    public Service(Repository repositoryangajat) {
        this.repositoryAngajat = repositoryangajat;
    }

    public Iterable<Angajat> getAll(){
        return repositoryAngajat.findAll();
    }

    public List<Angajat> getListEntity(){
        Iterable<Angajat> entityIterable = repositoryAngajat.findAll();
        List<Angajat> listaEntities = new ArrayList<>();
        entityIterable.forEach(listaEntities::add);
        return listaEntities;
    }
}
