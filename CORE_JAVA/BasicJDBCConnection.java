import java.sql.*;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        // SQLite database URL (it will be created if it doesn't exist)
        String url = "jdbc:sqlite:students.db";
        
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            // Create connection
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection established successfully!");
            
            // Create a students table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "age INTEGER)";
            
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Table created successfully!");
            
            // Insert sample data
            String insertSQL = "INSERT INTO students (name, age) VALUES ('Alice', 20)," +
                    "('Bob', 21), ('Charlie', 19)";
            statement.execute(insertSQL);
            System.out.println("Data inserted successfully!");
            
            // Execute a SELECT query
            String selectSQL = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            
            System.out.println("\nStudent Records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
            
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
