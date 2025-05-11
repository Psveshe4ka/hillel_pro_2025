package lessons_29;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "age INTEGER," +
                "position VARCHAR(100)," +
                "salary FLOAT" +
                ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(String name, int age, String position, float salary) {
        String sql = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, position);
            pstmt.setFloat(4, salary);
            pstmt.executeUpdate();
            System.out.println("Сотрудник добавлен.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String name, int age, String position, float salary) {
        String sql = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, position);
            pstmt.setFloat(4, salary);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Сотрудник обновлен.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Сотрудник удален.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getEmployee(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Имя: " + rs.getString("name") +
                        ", Возраст: " + rs.getInt("age") +
                        ", Должность: " + rs.getString("position") +
                        ", Зарплата: " + rs.getFloat("salary"));
            } else {
                System.out.println("Сотрудник не найден.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllEmployees() {
        List<String> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String employee = "ID: " + rs.getInt("id") +
                        ", Имя: " + rs.getString("name") +
                        ", Возраст: " + rs.getInt("age") +
                        ", Должность: " + rs.getString("position") +
                        ", Зарплата: " + rs.getFloat("salary");
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

