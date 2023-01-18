package org.example;

import org.example.UI.UI;
import org.example.repository.Repository;
import org.example.service.Service;

public class Main {
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/school";
        String username = "postgres";
        String password = "postgres";

        Repository repository = new Repository(url, username, password);
        Service service = new Service(repository);
        UI ui = new UI(service);

        ui.start();
    }
}