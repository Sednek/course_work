import basic.Employee;
import basic.Data;
import basic.BasicService;
import advanced.AdvancedService;

import SoHardSoGood.EmployeeBook;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Тесты EmployeeBook
        /*EmployeeBook eBook = new EmployeeBook();

        eBook.addEmployee();
        eBook.addEmployee();

        eBook.changeEmployeeSalary("Демин Никита Владиславович", 1, 15000);
        eBook.changeEmployeeDepartment("Демин Никита Владиславович", 1, 5);
        System.out.println(eBook.calculateAllMonthSalaries());
        eBook.fireEmployee(2);
        eBook.addEmployee();
        eBook.printEmployeesByDepartments();
        */

        //Менюшка по Basic и Advanced заданиям для упрощения тестирования, чтобы несколько раз менять значения.
        Data data = new Data();

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = data.createEmployee();
        }

        BasicService bs = new BasicService();

        AdvancedService as = new AdvancedService();

        Scanner in = new Scanner(System.in);

        boolean menu = true;

        while (menu) {
            System.out.println(" ");
            System.out.println("Книга сотрудников");
            System.out.println("1.  Получить всю информацию о сотрудниках");
            System.out.println("2.  Посчитать суммарную месячную зарплату");
            System.out.println("3.  Найти сотрудника с минимальной З.П.");
            System.out.println("4.  Найти сотрудника с максимальной З.П.");
            System.out.println("5.  Посчитать среднее значение зарплат.");
            System.out.println("6.  Получить имена всех сотрудников");
            System.out.println("Расширенные настройки:");
            System.out.println("7.  Проиндексировать зарплату всех сотрудников");
            System.out.println("8.  Найти сотрудника с минимальной З.П. по отделу");
            System.out.println("9.  Найти сотрудника с максимальной З.П. по отделу");
            System.out.println("10. Посчитать суммарную месячную зарплату по отделу");
            System.out.println("11. Посчитать среднее значение заработной платы по отделу");
            System.out.println("12. Проиндексировать зарплату сотрудников отдела");
            System.out.println("13. Получить данные всех сотрудников отдела");
            System.out.println("14. Получить список всех сотрудников с зарплатой меньше числа");
            System.out.println("15. Получить список всех сотрудников с зарплатой больше числа");
            System.out.println("0.  Выйти из приложения");
            System.out.print("Введите в консоль необходимый пункт меню: ");

            int menuButton = in.nextInt();
            System.out.println(" ");

            switch (menuButton) {
                case 1:
                    bs.printEmployeesInfo(employees);
                    break;

                case 2:
                    System.out.println("Итог: " + bs.calculateAllMonthSalaries(employees) + " Руб.");
                    break;

                case 3:
                    Employee minSalaryEmployee = bs.findMinSalaryEmployee(employees);
                    System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.getName() + ", его зарплата - " + minSalaryEmployee.getSalary() + " Руб.");
                    break;

                case 4:
                    Employee maxSalaryEmployee = bs.findMaxSalaryEmployee(employees);
                    System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.getName() + ", его зарплата - " + maxSalaryEmployee.getSalary() + " Руб.");
                    break;

                case 5:
                    double median = bs.findMedianSalary(employees);
                    System.out.println("Среднее значение заработных плат: " + median + " Руб.");
                    break;

                case 6:
                    bs.printEmployeesNames(employees);
                    break;

                case 7:
                    System.out.print("Введите %, на который хотите поднять зарплату сотрудникам: ");
                    int index = in.nextInt();
                    as.indexSalary(employees, index);
                    System.out.println("Зарплаты проиндексированны!");
                    break;

                case 8:
                    System.out.print("Введите номер департамента: ");
                    int depToFindMin = in.nextInt();
                    Employee minSalaryEmployeeInDep = as.findMinSalaryByDepartment(depToFindMin, employees);
                    System.out.println(minSalaryEmployeeInDep);
                    break;

                case 9:
                    System.out.print("Введите номер департамента: ");
                    int depToFindMax = in.nextInt();
                    Employee maxSalaryEmployeeInDep = as.findMaxSalaryByDepartment(depToFindMax, employees);
                    System.out.println(maxSalaryEmployeeInDep);
                    break;

                case 10:
                    System.out.print("Введите номер департамента: ");
                    int depToFindSumSalary = in.nextInt();
                    System.out.println("Итог: " + as.calculateAllMonthSalariesByDepartment(depToFindSumSalary, employees) + " Руб.");
                    break;

                case 11:
                    System.out.print("Введите номер департамента: ");
                    int depToFindMedian = in.nextInt();
                    double medianForAdvanced = as.findMedianSalaryByDepartment(depToFindMedian, employees);
                    System.out.println("Среднее значение заработных плат: " + medianForAdvanced + " Руб.");
                    break;

                case 12:
                    System.out.print("Введите номер департамента: ");
                    int depForIndexByDep = in.nextInt();
                    System.out.print("Введите %, на который хотите поднять зарплату сотрудникам: ");
                    int indexForSalaryByDep = in.nextInt();
                    as.indexSalaryByDepartment(depForIndexByDep, employees, indexForSalaryByDep);
                    break;

                case 13:
                    System.out.print("Введите номер департамента: ");
                    int depToFindEmp = in.nextInt();
                    as.printAllEmployeesInDepartment(depToFindEmp, employees);
                    break;

                case 14:
                    System.out.println("Введите число, чтобы получить всех сотрудников с зарплатой меньше этого числа: ");
                    int numberForPrintLess = in.nextInt();
                    as.printAllEmployeesWithWagesLessThan(numberForPrintLess, employees);
                    break;

                case 15:
                    System.out.println("Введите число, чтобы получить всех сотрудников с зарплатой больше этого числа: ");
                    int numberForPrintMore = in.nextInt();
                    as.printAllEmployeesWithWagesMoreThan(numberForPrintMore, employees);
                    break;

                case 0:
                    menu = false;
                    break;

                default:
                    System.out.println("Что то пошло не так, попробуйте еще раз!");
                    break;
            }
        }
        in.close();
    }
}