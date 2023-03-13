package advanced;

import basic.Employee;

public class AdvancedService {
    public void indexSalary(Employee[] employees, int indexPercent){
        double newSalary = 0;
        for (int i = 0; i < employees.length; i++){
            double currentSalary = employees[i].getSalary();
            newSalary = currentSalary + (currentSalary * ( (double) indexPercent / 100));
            employees[i].setSalary(newSalary);
        }
    }

    public Employee findMinSalaryByDepartment(int department, Employee[] employees){
        double minSalary = 100000;
        Employee minSalaryEmployee = null;
        for(int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department && minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department && minSalary == employees[i].getSalary()){
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryByDepartment(int department, Employee[] employees){
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department && maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department && maxSalary == employees[i].getSalary()){
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    public double calculateAllMonthSalariesByDepartment(int department,Employee[] employees){
        double sum = 0;

        for(int i = 0; i < employees.length; i++){
            if(employees[i].getDepartment() == department) {
                sum = sum + employees[i].getSalary();
            }
        }
        return sum;
    }

    public double findMedianSalaryByDepartment(int department,Employee[] employees){
        double sum = calculateAllMonthSalariesByDepartment(department, employees);
        double median;
        int numOfEmployees = 0;
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getDepartment() == department) {
                numOfEmployees++;
            }
        }

        median = sum / (double) numOfEmployees;

        return median;
    }

    public void indexSalaryByDepartment(int department, Employee[] employees, int indexPercent){
        double newSalary = 0;
        for (int i = 0; i < employees.length; i++){
            if(employees[i].getDepartment() == department) {
                double currentSalary = employees[i].getSalary();
                newSalary = currentSalary + (currentSalary * ((double) indexPercent / 100));
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void printAllEmployeesInDepartment(int department, Employee[] employees){
        for (Employee e : employees){
            if(e.getDepartment() == department) {
                System.out.printf("id: %d, name: %s, salary: %.2f\n", e.getId(), e.getName(), e.getSalary());
            }
        }
    }

    public void printAllEmployeesWithWagesLessThan(int number, Employee[] employees){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getSalary() < number){
                System.out.println(employees[i]);
            }
        }
    }
    public void printAllEmployeesWithWagesMoreThan(int number, Employee[] employees){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getSalary() >= number){
                System.out.println(employees[i]);
            }
        }
    }
}
