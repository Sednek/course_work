package basic;

public class BasicService {
    public void printEmployeesInfo(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public double calculateAllMonthSalaries(Employee[] employees) {
        double sum = 0;

        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public Employee findMinSalaryEmployee(Employee[] employees) {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (minSalaryEmployee.getSalary() > employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (maxSalaryEmployee.getSalary() < employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double findMedianSalary(Employee[] employees) {
        double sum = calculateAllMonthSalaries(employees);
        double median;

        median = sum / (double) employees.length;

        return median;
    }

    public void printEmployeesNames(Employee[] employees) {
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
}
