package com.shankar.dao.inter;

import java.util.List;

import com.shankar.model.Employee;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();
    Employee findEmployeeById(int employeeId);
    boolean saveEmployee(Employee employee);
    boolean updateEmployee(int employeeId, Employee employee);
    boolean deleteEmployee(int employeeId);
}
