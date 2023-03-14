package basic;

import java.util.Random;

public class Data {
    private final String[] name      = {"Иван ", "Александр ", "Сергей ", "Никита ", "Максим "};
    private final String[] surName   = {"Иванов ", "Александров ", "Сергеев ", "Демин ", "Дорофеев "};
    private final String[] thirdName = {"Иванович", "Александрович", "Сергеевич", "Игоревич", "Дмитриевич"};

    Random rnd = new Random();

    public Employee createEmployee() {
        String nameData = surName[rnd.nextInt(surName.length)] + name[rnd.nextInt(name.length)] + thirdName[rnd.nextInt(thirdName.length)];
        int maxDepartment = 5;
        int minDepartment = 1;
        int departmentData = minDepartment + rnd.nextInt(maxDepartment);
        int maxSalary = 100000;
        int minSalary = 10000;
        int salaryData = minSalary + rnd.nextInt(maxSalary - minSalary);
        return new Employee(
                nameData,
                departmentData,
                salaryData
        );
    }
}
