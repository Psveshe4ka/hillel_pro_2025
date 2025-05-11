package lessons_29;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.connect();

        EmployeeDAO employeeDAO = new EmployeeDAO(databaseConnector.getConnection());

        employeeDAO.createTable();


        employeeDAO.addEmployee("Вася Петечкин", 30, "Разработчик", 50000);
        employeeDAO.addEmployee("Лариса Петечкина", 25, "Тестировщик", 40000);


        employeeDAO.updateEmployee(1, "Вася Петечкин", 31, "Старший разработчик", 60000);

        employeeDAO.getEmployee(1);

        System.out.println("\nСписок всех сотрудников:");
        for (String employee : employeeDAO.getAllEmployees()) {
            System.out.println(employee);
        }

        employeeDAO.deleteEmployee(2);

        databaseConnector.close();
    }
}


