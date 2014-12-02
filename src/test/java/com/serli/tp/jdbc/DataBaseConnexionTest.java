package com.serli.tp.jdbc;

import com.serli.tp.java.oo.vehicules.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataBaseConnexionTest {

    private Connection connection;

    @Before
    public void createConnexion() throws SQLException {
        connection = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");

        Statement statement = connection.createStatement();

        statement.execute("DROP TABLE CAR IF EXISTS");

        statement.execute("CREATE TABLE CAR(\n" +
                "\tNAME VARCHAR(25) NOT NULL,\n" +
                "\tYEAR INTEGER NOT NULL,\n" +
                "\tPRIMARY KEY (NAME, YEAR));");

    }

    @After
    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void shouldCheckConnection() throws SQLException {
        assertTrue(connection.isValid(1000));
    }

    public void insertDate() throws SQLException {
        try (Statement statement = connection.createStatement();) {
            statement.executeUpdate("INSERT INTO CAR VALUES ('PEUGEOT', 2013)");
            statement.executeUpdate("INSERT INTO CAR VALUES ('RENAULT', 2012)");
            statement.executeUpdate("INSERT INTO CAR VALUES ('SIMCA', 1984)");

        }
    }

    @Test
    public void shouldExecuteQuery() throws SQLException {
        insertDate();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM CAR");) {

            Set<Car> fetchedCars = new HashSet<>();
            while (resultSet.next()) {
                int year = resultSet.getInt("YEAR");
                String name = resultSet.getString("NAME");

                Car car = new Car(name, year);
                fetchedCars.add(car);
            }

            assertEquals(3, fetchedCars.size());
        }
    }

    @Test
    public void shouldUsePreparedStatement() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CAR VALUES (?, ?)");) {
            preparedStatement.setString(1, "ALFA ROMEO");
            preparedStatement.setInt(2, 2002);
            preparedStatement.execute();
        }


    }

    @Test
    public void shouldBeTransactionnal() throws SQLException {
        try (Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);

            statement.execute("INSERT INTO CAR VALUES ('PEUGEOT', 2013)");

            connection.commit();
        }
    }


}
