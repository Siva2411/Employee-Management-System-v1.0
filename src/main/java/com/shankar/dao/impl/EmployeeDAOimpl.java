package com.shankar.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.shankar.config.DatabaseConfig;
import com.shankar.dao.inter.EmployeeDAO;
import com.shankar.enums.Gender;
import com.shankar.model.Employee;

public class EmployeeDAOimpl implements EmployeeDAO{

	@Override
	public List<Employee> findAllEmployees() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DatabaseConfig.getConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employeedb.employee");
			List<Employee> employees = new ArrayList<>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartmentId(resultSet.getInt("department_id"));
				employee.setMobile_number(resultSet.getString("mobile_number"));
				employee.setGender(Gender.valueOf(resultSet.getString("gender")));
				employees.add(employee);
			}
			return employees;
		}
		catch (SQLException e) {
			System.err.println("Database employeedb connection failed!!");
			e.printStackTrace();
		}
		finally{
			try {
				if(Objects.nonNull(statement))
				{
					statement.close();
					
				}
				if(Objects.nonNull(connection))
				{
					connection.close();
				}
			}
			catch(SQLException exception)
			{
				System.err.println("Statement is failed to close!!");
				exception.printStackTrace();
			}
			
		}
		return null;
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
	}

	@Override
	public void updateEmployee(int employeeId, Employee employee) {

	}

	@Override
	public void deleteEmployee(int employeeId) {

	}
}
