package com.shankar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.shankar.config.DatabaseConfig;
import com.shankar.dao.inter.EmployeeDAO;
import com.shankar.model.Employee;
import com.shankar.util.EmployeeUtil;

public class EmployeeDAOimpl implements EmployeeDAO {

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employeedb.employee";
        
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
            	Employee employee = EmployeeUtil.mapToEmployee(resultSet);
                employees.add(employee);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        String query = "SELECT * FROM employeedb.employee WHERE id = ?";
        ResultSet resultSet  = null;
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            resultSet = statement.executeQuery();
            Employee employee = null;
            if (resultSet.next()) {
            	employee = EmployeeUtil.mapToEmployee(resultSet);
            }
            /*ResultSet resource close*/
            if(Objects.nonNull(resultSet)) {
            	resultSet.close();
            }
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        String query = "INSERT INTO employee (id, name, mobile_number, email_id, gender, department_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
			EmployeeUtil.setEmployeeParams(preparedStatement, employee);

			return preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployee(int employeeId, Employee employee) {
        String query = "UPDATE employee WHERE id=? SET name=?, mobile_number=?, email_id=?, gender=?, department_id=?";
        
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            EmployeeUtil.setEmployeeParams(preparedStatement, employee);
            return preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        String query = "DELETE FROM employee WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            return statement.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
