package basic;

public class BasicService {
    public void printEmployeesInfo(Employee[] employees){
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public double calculateAllMonthSalaries(Employee[] employees){
        double sum = 0;

        for(int i = 0; i < employees.length; i++){
            sum = sum + employees[i].getSalary();
        }
        return sum;
    }

    public Employee findMinSalaryEmployee(Employee[] employees){
        double minSalary = 100000;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employees.length; i++){
            if (minSalary > employees[i].getSalary()){
                minSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++){
            if (minSalary == employees[i].getSalary()){
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee(Employee[] employees){
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (int i = 0; i < employees.length; i++){
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

    public double findMedianSalary(Employee[] employees){
        double sum = calculateAllMonthSalaries(employees);
        double median;
        int numOfEmployees = 0;
        for(int i = 0; i < employees.length; i++){
            numOfEmployees++;
        }

        median = sum / (double) numOfEmployees;

        return median;
    }

    public void printEmployeesNames(Employee[] employees){
        for(Employee e : employees){
            System.out.println(e.getName());
        }
    }
}
