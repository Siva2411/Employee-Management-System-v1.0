package com.shankar.dao.inter;

import java.util.List;

import com.shankar.model.Employee;

public interface EmployeeDAO {
	public abstract List<Employee> findAllEmployees();
	public abstract Employee findEmployeeById(int employeeId);
	public abstract void saveEmployee(Employee employee);
	public abstract void updateEmployee(int employeeId,Employee employee);
	public abstract void deleteEmployee(int employeeId);
}
