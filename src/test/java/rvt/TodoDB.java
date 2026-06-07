package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class TodoDB {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB() {
        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
                + "id INTEGER PRIMARY KEY, "
                + "task TEXT NOT NULL)";

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();

            stmt.execute(sql);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }

    public void add(String task) {
        String sql = "INSERT INTO todo(task) VALUES(?)";

        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, task);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Add failed: " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT id, task FROM todo";

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(sql);

            while (results.next()) {
                int id = results.getInt("id");
                String task = results.getString("task");

                System.out.println(id + ": " + task);
            }

            results.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Find failed: " + e.getMessage());
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";

        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Remove failed: " + e.getMessage());
        }
    }
}