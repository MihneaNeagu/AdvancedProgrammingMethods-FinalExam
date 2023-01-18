package org.example.repository;

import org.example.Domain.Angajat;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Repository{
    private String url;
    private String username;
    private String password;
    public Repository(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Iterable<Angajat> findAll(){
        Set<Angajat> entities = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("select * from entities");
        ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                Long idEntity = resultSet.getLong("idEntity");
                String firstName = resultSet.getString("nume");
                String lastName = resultSet.getString("prenume");
                String grupa = resultSet.getString("post");
                Double media = resultSet.getDouble("salariu");

                Angajat utilizator = new Angajat(idEntity, firstName, lastName, grupa, media);
                utilizator.setIdAngajat(idEntity);
                entities.add(utilizator);
            }
            return entities;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }
}
