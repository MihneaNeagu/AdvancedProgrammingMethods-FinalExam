package org.example.Domain;

import java.util.Objects;

public class Angajat {
    @Override
    public String toString() {
        return "Angajat{" +
                "idEntity=" + idEntity +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", post='" + post + '\'' +
                ", salariu=" + salariu +
                '}';
    }

    public long getIdAngajat() {
        return idEntity;
    }

    public void setIdAngajat(long idEntity) {
        this.idEntity = idEntity;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    private long idEntity;
    private String nume;
    private String prenume;
    private String post;
    private double salariu;

    public Angajat(long idEntity, String nume, String prenume, String post, double salariu) {
        this.idEntity = idEntity;
        this.nume = nume;
        this.prenume = prenume;
        this.post = post;
        this.salariu = salariu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return idEntity == angajat.idEntity && Double.compare(angajat.salariu, salariu) == 0 && Objects.equals(nume, angajat.nume) && Objects.equals(prenume, angajat.prenume) && Objects.equals(post, angajat.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntity, nume, prenume, post, salariu);
    }
}
