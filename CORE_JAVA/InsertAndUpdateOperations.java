import java.sql.*;

// StudentDAO class for database operations
class StudentDAO {
    private String url = "jdbc:sqlite:students_dao.db";
    
    public StudentDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found: " + e.getMessage());
        }
    }
    
    // Initialize database with students table
    public void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "age INTEGER)";
            
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
            System.out.println("Database initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }
    
    // Insert a new student record
    public void insertStudent(String name, int age) {
        String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";
        
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.executeUpdate();
            System.out.println("Student " + name + " inserted successfully!");
            
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }
    
    // Update student details
    public void updateStudent(int id, String name, int age) {
        String updateSQL = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Student ID " + id + " updated successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }
            
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
    
    // Display all students
    public void displayAllStudents() {
        String selectSQL = "SELECT * FROM students";
        
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            
            System.out.println("\nAll Students:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + 
                        ", Name: " + resultSet.getString("name") + 
                        ", Age: " + resultSet.getInt("age"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }
}

public class InsertAndUpdateOperations {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.initializeDatabase();
        
        // Insert new students
        dao.insertStudent("Alice", 20);
        dao.insertStudent("Bob", 21);
        dao.insertStudent("Charlie", 19);
        
        // Display all students
        dao.displayAllStudents();
        
        // Update a student
        dao.updateStudent(1, "Alice Johnson", 21);
        
        // Display updated records
        dao.displayAllStudents();
    }
}
