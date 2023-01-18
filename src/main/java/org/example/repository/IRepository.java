package org.example.repository;

import org.example.Domain.Angajat;

import java.util.List;

public interface IRepository {
    void loadData();
    List<Angajat> getAllAngajati();
}
