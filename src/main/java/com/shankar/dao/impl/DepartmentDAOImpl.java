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
import com.shankar.dao.inter.DepartmentDAO;
import com.shankar.model.Department;

public class DepartmentDAOImpl implements DepartmentDAO{
	@Override
	public List<Department> findAllDepartments() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DatabaseConfig.getConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employeedb.department");
			List<Department> departments = new ArrayList<>();
			while (resultSet.next()) {
				Department department = new Department();
				department.setDepartmentId(resultSet.getInt("department_id"));
				department.setName(resultSet.getString("name"));
				department.setLocation(resultSet.getString("location"));
				departments.add(department);
			}
			return departments;
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
	public Department findDepartmentById(int departmentId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConfig.getConnection();
			preparedStatement = connection.prepareStatement("select * from department where department_id = ?");
			preparedStatement.setInt(1, departmentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Department department = null;
			while (resultSet.next()) {
				department = new Department();
				department.setDepartmentId(resultSet.getInt("department_id"));
				department.setName(resultSet.getString("name"));
				department.setLocation(resultSet.getString("location"));
			}
			return department;
		}
		catch (SQLException e) {
			System.err.println("Database employeedb connection failed!!");
			e.printStackTrace();
		} 
		finally{
			try {
				if(Objects.nonNull(preparedStatement))
				{
					preparedStatement.close();
					
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
	public void saveDepartment(Department department) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConfig.getConnection();
			preparedStatement = connection.prepareStatement("insert into department values(?, ?, ?)");
			preparedStatement.setInt(1, department.getDepartmentId());
			preparedStatement.setString(2, department.getName());
			preparedStatement.setString(3, department.getLocation());
			int n = preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("Database employeedb connection failed!!");
			e.printStackTrace();
		} 
		finally{
			try {
				if(Objects.nonNull(preparedStatement))
				{
					preparedStatement.close();
					
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
	}
	@Override
	public void updateDepartment(int departmentId, Department department) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConfig.getConnection();
			preparedStatement = connection.prepareStatement("update department set name = ? , location = ? where `department_id` = ?");

			preparedStatement.setString(1, department.getName());
			preparedStatement.setString(2, department.getLocation());
			int n = preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("Database employeedb connection failed!!");
			e.printStackTrace();
		} 
		finally{
			try {
				if(Objects.nonNull(preparedStatement))
				{
					preparedStatement.close();
					
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
	}
	@Override
	public void deleteDepartment(int departmentId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConfig.getConnection();
			preparedStatement = connection.prepareStatement("delete department where `department_id` = ?");

			preparedStatement.setInt(1, departmentId);
			int n = preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("Database employeedb connection failed!!");
			e.printStackTrace();
		} 
		finally{
			try {
				if(Objects.nonNull(preparedStatement))
				{
					preparedStatement.close();
					
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
	}
}
