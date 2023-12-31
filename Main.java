package db;
/*

}

*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/experiment";
        String username = "root";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            List<ChemicalSample> chemicalSamples = getChemicalSamples(connection);
            List<Crew> crews = getCrews(connection);

            for (ChemicalSample sample : chemicalSamples) {
                System.out.println(sample);
            }

            for (Crew crew : crews) {
                System.out.println(crew);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<ChemicalSample> getChemicalSamples(Connection connection) throws SQLException {
        List<ChemicalSample> chemicalSamples = new ArrayList<>();

        String query = "SELECT * FROM chemical_samples";
        try (Statement statement = connection.createStatement() ;
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()) {
                int id = resultSet.getInt("idchemical_samples");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");

                ChemicalSample sample = new ChemicalSample(id, name, quantity);
                chemicalSamples.add(sample);
            }
        }

        return chemicalSamples;
    }

    private static List<Crew> getCrews(Connection connection) throws SQLException {
        List<Crew> crews = new ArrayList<>();

        String query = "SELECT * FROM crews";
        try (Statement statement = connection.createStatement() ;
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()) {
                int id = resultSet.getInt("idcrews");
                String name = resultSet.getString("name");
                int members = resultSet.getInt("members");

                Crew crew = new Crew(id, name, members);
                crews.add(crew);
            }
        }

        return crews;
    }
}

class ChemicalSample {
    private int id;
    private String name;
    private int quantity;

    public ChemicalSample(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // getters and setters

    @Override
    public String toString() {
        return "Хим образцы{" +
                "Номер=" + id +
                ", Название='" + name + '\'' +
                ", Количество=" + quantity +
                '}';
    }
}

class Crew {
    private int id;
    private String name;
    private int members;

    public Crew(int id, String name, int members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    // getters and setters

    @Override
    public String toString() {
        return "Группа{" +
                "Номер=" + id +
                ", Название='" + name + '\'' +
                ", Количество=" + members +
                '}';
    }
}
