import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] SURNAMES = {"Иванов", "Александров", "Петров", "Павлов", "Никитин", "Сидоров"};
    private final static String[] NAMES = {"Петр", "Иван", "Василий", "Илья", "Сергей", "Михаил"};
    private final static String[] PATRONYMIC_NAMES = {"Иванович", "Александрович", "Петрович", "Павлович", "Сергеевич", "Львович"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " + PATRONYMIC_NAMES[RANDOM.nextInt(0, PATRONYMIC_NAMES.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(60000, 120000));
        }

    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма зарплат сотрудников " + calculateSumOfSalaries());
        System.out.println("Сотрудник с минемальной зарплатой " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой " + findEmployeeWithMaxSalary());
        System.out.println("Средняя зарплата сотрудников " + calculateAverageOfSalaries());
        printFullName();
    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();

        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;

    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;

    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;

    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}


