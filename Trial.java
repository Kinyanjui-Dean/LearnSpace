import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trial {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/learnspace";
        String user = "postgres";
        String password = "passcode";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection established successfully!");

            // Create an INSERT query
            String insertQuery = "INSERT INTO course (name) VALUES (?);";

            // Create a PreparedStatement to execute the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for the placeholders in the query
            preparedStatement.setString(1, "Java Programming");  // Insert 'Java Programming' into the 'name' column
            preparedStatement.executeUpdate();  // Execute the INSERT

            preparedStatement.setString(1, "Data Structures");  // Insert 'Data Structures' into the 'name' column
            preparedStatement.executeUpdate();  // Execute the INSERT

            preparedStatement.setString(1, "Web Development");  // Insert 'Web Development' into the 'name' column
            preparedStatement.executeUpdate();  // Execute the INSERT

            System.out.println("Data inserted successfully into 'course' table.");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
