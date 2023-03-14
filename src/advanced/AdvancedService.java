package advanced;

import basic.Employee;

public class AdvancedService {
    public void indexSalary(Employee[] employees, int indexPercent) {
        double newSalary;
        for (Employee employee : employees) {
            double currentSalary = employee.getSalary();
            newSalary = currentSalary + (currentSalary * ((double) indexPercent / 100));
            employee.setSalary(newSalary);
        }
    }

    public Employee findMinSalaryByDepartment(int department, Employee[] employees) {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && minSalaryEmployee.getSalary() > employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryByDepartment(int department, Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && maxSalaryEmployee.getSalary() < employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double calculateAllMonthSalariesByDepartment(int department, Employee[] employees) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    public double findMedianSalaryByDepartment(int department, Employee[] employees) {
        double sum = calculateAllMonthSalariesByDepartment(department, employees);
        double median;
        int numOfEmployees = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                numOfEmployees++;
            }
        }

        median = sum / (double) numOfEmployees;

        return median;
    }

    public void indexSalaryByDepartment(int department, Employee[] employees, int indexPercent) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                double currentSalary = employee.getSalary();
                newSalary = currentSalary + (currentSalary * ((double) indexPercent / 100));
                employee.setSalary(newSalary);
            }
        }
    }

    public void printAllEmployeesInDepartment(int department, Employee[] employees) {
        for (Employee e : employees) {
            if (e.getDepartment() == department) {
                System.out.printf("id: %d, name: %s, salary: %.2f\n", e.getId(), e.getName(), e.getSalary());
            }
        }
    }

    public void printAllEmployeesWithWagesLessThan(int number, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployeesWithWagesMoreThan(int number, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                System.out.println(employee);
            }
        }
    }
}
