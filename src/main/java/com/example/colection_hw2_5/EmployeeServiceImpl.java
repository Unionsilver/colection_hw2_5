package com.example.colection_hw2_5;

import com.example.colection_hw2_5.Exception.EmployeeAlreadyAddedException;
import com.example.colection_hw2_5.Exception.EmployeeNotFoundException;
import com.example.colection_hw2_5.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public String employees(String firstName, String lastName) {


        List<Employee> employeesWorker = List.of(

                new Employee("Осип", "Одинцов"),
                new Employee("Артем", "Денисов"),
                new Employee("Герасим", "Большаков"),
                new Employee("Оскар", "Калинин"),
                new Employee("Виталий", "Коновалов"),
                new Employee("Флор", "Никитин"),
                new Employee("Александр", "Кабанов"),
                new Employee("Григорий", "Семёнов"),
                new Employee("Аверкий", "Егоров"),
                new Employee("Исаак", "Филатов")
        );

        System.out.println(employeesWorker);
        return firstName;
    }

    public void addWorkers(String firstName, String lastName) {
        employees.add(new Employee("Алексей", "Алексеевич"));
        throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");
    }

    public String removeWorkers(String firstName, String lastName) {
        removeWorkers(firstName, lastName);
        throw new EmployeeNotFoundException("Не найден сотрудник что бы удалить");

    }

    public String searchWorkers(String firstName, String lastName) {
        searchWorkers(firstName, lastName);
        throw new EmployeeNotFoundException("Не найден сотрудник в поиске");
    }

    public void sameEmployee(String firstName, String lastName) {
        sameEmployee(firstName, lastName);
        throw new EmployeeAlreadyAddedException("попытка добавить одинаково сотрудника");
    }

    @Override
    public String addPerson(String firstName, String lastName) {
        return "гг";
    }
}