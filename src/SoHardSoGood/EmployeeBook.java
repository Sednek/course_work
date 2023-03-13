package SoHardSoGood;

import basic.Employee;

import java.util.Scanner;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void addEmployee(){
        for(int i = 0; i < employees.length; i++){
            Scanner in = new Scanner(System.in);
            if (employees[i] == null){
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
    public void fireEmployee(int id){
        for(int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            if(employees[i].getId() == id){
                employees[i] = null;
            }
        }
    }

    public void changeEmployeeSalary(String name, int id, double salary){
        for(int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            if(employees[i].getName().equals(name) && employees[i].getId() == id){
                employees[i].setSalary(salary);
            }
        }
    }

    public void changeEmployeeDepartment(String name, int id, int department){
        for(int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            if(employees[i].getName().equals(name) && employees[i].getId() == id){
                employees[i].setDepartment(department);
            }
        }
    }

    public void printEmployeesByDepartments(){
        for (int i = 1; i <= 5; i++){
            System.out.println("Отдел №" + i);
            for (int j = 0; j < employees.length; j++){
                if(employees[j] == null){
                    continue;
                }
                if (employees[j].getDepartment() == i){
                    System.out.printf("id: %d, Имя: %s, Зарплата: %.2f\n", employees[j].getId(), employees[j].getName(), employees[j].getSalary());
                }
            }
        }
    }



    public void printEmployeesInfo(){
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public double calculateAllMonthSalaries(){
        double sum = 0;

        for(int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            sum = sum + employees[i].getSalary();
        }
        return sum;
    }

    public Employee findMinSalaryEmployee(){
        double minSalary = 100000;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            if (minSalary > employees[i].getSalary()){
                minSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            if (minSalary == employees[i].getSalary()){
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee(){
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++){
            if (maxSalary == employees[i].getSalary()){
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    public double findMedianSalary(){
        double sum = calculateAllMonthSalaries();
        double median;
        int numOfEmployees = 0;
        for(int i = 0; i < employees.length; i++){
            if(employees[i] == null){
                continue;
            }
            numOfEmployees++;
        }

        median = sum / (double) numOfEmployees;

        return median;
    }

    public void printEmployeesNames(){
        for(Employee e : employees){
            if(e == null){
                continue;
            }
            System.out.println(e.getName());
        }
    }
}
