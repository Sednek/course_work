package SoHardSoGood;

import basic.Employee;

import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void addEmployee() {
        for (int i = 0; i < employees.length; i++) {
            Scanner in = new Scanner(System.in);
            if (employees[i] == null) {
                System.out.println("Введите имя сотрудника: ");
                String name = in.nextLine();
                System.out.println("Введите отдел сотрудника: ");
                int department = in.nextInt();
                System.out.println("Введите зарплату сотрудника: ");
                int salary = in.nextInt();
                Employee employee = new Employee(name, department, salary);
                employees[i] = employee;
                in.reset();
                break;
            }
        }
    }

    public void fireEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void changeEmployeeSalary(String name, int id, double salary) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getName().equals(name) && employee.getId() == id) {
                employee.setSalary(salary);
            }
        }
    }

    public void changeEmployeeDepartment(String name, int id, int department) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getName().equals(name) && employee.getId() == id) {
                employee.setDepartment(department);
            }
        }
    }

    public void printEmployeesByDepartments() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел №" + i);
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == i) {
                    System.out.printf("id: %d, Имя: %s, Зарплата: %.2f\n", employee.getId(), employee.getName(), employee.getSalary());
                }
            }
        }
    }


    public void printEmployeesInfo() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public double calculateAllMonthSalaries() {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public Employee findMinSalaryEmployee() {
        double minSalary = 100000;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (minSalary == employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee() {
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        for (Employee employee : employees) {
            if (maxSalary == employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double findMedianSalary() {
        double sum = calculateAllMonthSalaries();
        double median;
        int numOfEmployees = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            numOfEmployees++;
        }

        median = sum / (double) numOfEmployees;

        return median;
    }

    public void printEmployeesNames() {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            System.out.println(e.getName());
        }
    }
}
