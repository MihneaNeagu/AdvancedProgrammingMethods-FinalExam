package org.example.UI;

import org.example.Domain.Angajat;
import org.example.service.Service;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UI {
    private Service service;
    private Scanner scanner;

    public UI(Service service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    private void optiuni()
    {
        System.out.println("0.Exit.");
        System.out.println("1.Cautare angajat Ionescu Paul.");
        System.out.println("2.Filtrare angajati cu post programator.");
        System.out.println("3.Filtrare angajati cu post programator si salariu>5000.");
        System.out.println("4.Sortare dupa nume si prenume alfabetic descrescator");
        System.out.println("5.Sortare dupa post crescator.");
        System.out.println("6.Sortare dupa salariu descrescator.");

    }



    public void start(){
        int optiune;
        while (true){
            optiuni();
            System.out.println("Dati optiunea: ");
            optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune){
                case 0 -> {return ;}
                case 1 -> System.out.println(findEntityNumePrenume());
                case 2 -> filtrareProgramator();
                case 3 -> filtrareProgramatorSalariu();
                case 4 -> filtrareNumePrenumeDescrescator();
                case 5 -> filtrarePostCrescator();
                case 6 -> filtrareSalariuDescrescator();

            }
        }
    }

    private String citire(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }
    private String findEntityNumePrenume() {
        //String nume = citire("nume: ");
        //String prenume = citire("prenume: ");
        String nume = "Ionescu";
        String prenume = "Paul" ;
        List<Angajat> angajatList = service.getListEntity();
        for (int i = 0; i< angajatList.size(); i++){
            if (angajatList.get(i).getNume().equals(nume) && angajatList.get(i).getPrenume().equals(prenume))
                return angajatList.get(i).toString();
                //return "Exista";
        }
        return "Nu exista";
    }

    private void filtrareProgramator() {
        String post = "programator";
        List<Angajat> angajatList = service.getListEntity();
        List<Angajat> listaFiltrata = angajatList.stream().filter((s)->{return s.getPost().equals(post);}).collect(Collectors.toList());
        if (listaFiltrata.size() == 0){
            System.out.println("Lista este goala! Nu exista angajati cu acest post! ");
        }
        else System.out.println(listaFiltrata);
    }

    private void filtrareProgramatorSalariu() {
        String post = "programator";
        List<Angajat> angajatList = service.getListEntity();
        List<Angajat> listaFiltrata = angajatList.stream().filter((s)->{return s.getPost().equals(post);}).collect(Collectors.toList());
        List<Angajat> listaFiltrataSalariu = listaFiltrata.stream().filter((s)->{return s.getSalariu()>5000;}).collect(Collectors.toList());
        if (listaFiltrataSalariu.size() == 0){
            System.out.println("Lista este goala! Nu exista angajati de acest tip! ");
        }
        else System.out.println(listaFiltrataSalariu);
    }

    private void filtrareNumePrenumeDescrescator() {
        List<Angajat> angajatList = service.getListEntity();
        List<Angajat> sortedList = angajatList.stream().sorted(Comparator.comparing(Angajat::getNume).reversed().thenComparing(Angajat::getPrenume)).collect(Collectors.toList());
        Stream var = sortedList.stream().map((s)->{Long var1 = s.getIdAngajat();
            return " " + var1 + " " + s.getNume() + " " + s.getPrenume();
        });
        PrintStream var11= System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }

    private void filtrarePostCrescator() {
        List<Angajat> angajatList = service.getListEntity();
        List<Angajat> sortedList = angajatList.stream().sorted(Comparator.comparing(Angajat::getPost)).collect(Collectors.toList());
        Stream var = sortedList.stream().map((s)->{
            return " " + s.getNume() + " " + s.getPrenume() + " " + s.getPost();
        });
        PrintStream var11= System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }

    private void filtrareSalariuDescrescator() {
        List<Angajat> studentList = service.getListEntity();
        List<Angajat> sortedList = studentList.stream().sorted(Comparator.comparing(Angajat::getSalariu).reversed()).collect(Collectors.toList());
        Stream var = sortedList.stream().map((s)->{
            return " " + s.getIdAngajat() + " "  + s.getSalariu();
        });
        PrintStream var11= System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }


}
