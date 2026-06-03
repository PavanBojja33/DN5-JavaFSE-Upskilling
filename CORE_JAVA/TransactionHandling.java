import java.sql.*;

public class TransactionHandling {
    private static String url = "jdbc:sqlite:accounts.db";
    
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found: " + e.getMessage());
        }
    }
    
    public static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "account_id INTEGER PRIMARY KEY, " +
                    "account_holder TEXT NOT NULL, " +
                    "balance REAL NOT NULL)";
            
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
            
            // Insert sample accounts
            String insertSQL = "DELETE FROM accounts; " +
                    "INSERT INTO accounts VALUES (1, 'Alice', 1000.0); " +
                    "INSERT INTO accounts VALUES (2, 'Bob', 500.0)";
            
            statement.executeUpdate(insertSQL);
            System.out.println("Database initialized with accounts!");
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }
    
    // Transfer money between accounts with transaction handling
    public static void transfer(int fromAccountId, int toAccountId, double amount) {
        try (Connection connection = DriverManager.getConnection(url)) {
            // Disable auto-commit for manual transaction control
            connection.setAutoCommit(false);
            
            try {
                // Debit from source account
                String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
                PreparedStatement debitStatement = connection.prepareStatement(debitSQL);
                debitStatement.setDouble(1, amount);
                debitStatement.setInt(2, fromAccountId);
                int debitRows = debitStatement.executeUpdate();
                
                // Credit to destination account
                String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
                PreparedStatement creditStatement = connection.prepareStatement(creditSQL);
                creditStatement.setDouble(1, amount);
                creditStatement.setInt(2, toAccountId);
                int creditRows = creditStatement.executeUpdate();
                
                // Check if both operations were successful
                if (debitRows > 0 && creditRows > 0) {
                    connection.commit();
                    System.out.println("Transfer successful: $" + amount + " transferred from Account " + 
                            fromAccountId + " to Account " + toAccountId);
                } else {
                    connection.rollback();
                    System.out.println("Transfer failed: One or both accounts not found.");
                }
                
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Transfer failed, rolled back: " + e.getMessage());
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    // Display all accounts
    public static void displayAccounts() {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts")) {
            
            System.out.println("\nAccount Balances:");
            while (resultSet.next()) {
                System.out.println("Account " + resultSet.getInt("account_id") + 
                        ": " + resultSet.getString("account_holder") + 
                        " - Balance: $" + resultSet.getDouble("balance"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error retrieving accounts: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        initializeDatabase();
        
        displayAccounts();
        
        // Perform a transfer
        System.out.println("\n--- Transferring $200 from Account 1 to Account 2 ---");
        transfer(1, 2, 200.0);
        
        displayAccounts();
        
        // Try an invalid transfer (from non-existent account)
        System.out.println("\n--- Attempting invalid transfer ---");
        transfer(99, 1, 100.0);
        
        displayAccounts();
    }
}
