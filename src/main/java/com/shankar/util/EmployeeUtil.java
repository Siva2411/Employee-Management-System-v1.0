package com.shankar.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.shankar.enums.Gender;
import com.shankar.model.Employee;

public class EmployeeUtil {

	public static Employee mapToEmployee(ResultSet resultSet) throws SQLException {

		Employee employee = new Employee();
		employee.setId(resultSet.getInt("id"));
		employee.setName(resultSet.getString("name"));
		employee.setMobileNumber(resultSet.getString("mobile_number"));
		employee.setEmailId(resultSet.getString("email_id"));

		String genderStr = resultSet.getString("gender");
		if (genderStr != null) {
			employee.setGender(Gender.valueOf(genderStr));
		} else {
			employee.setGender(null);
		}
		employee.setDepartmentId(resultSet.getObject("department_id", Integer.class));
		return employee;
	}
	public static Employee mapToEmployee(int id, String name, String email, String mobile, Gender gender, int deptId){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setMobileNumber(mobile);
		employee.setEmailId(email);

		employee.setGender(gender);
		employee.setDepartmentId(deptId);
		return employee;
	}
	public static void setEmployeeParams(PreparedStatement preparedStatement, Employee employee) throws SQLException {
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());

		if (employee.getMobileNumber().isPresent()) {
			preparedStatement.setString(3, employee.getMobileNumber().get());
		} else {
			preparedStatement.setNull(3, Types.VARCHAR);
		}

		if (employee.getEmailId().isPresent()) {
			preparedStatement.setString(4, employee.getEmailId().get());
		} else {
			preparedStatement.setNull(4, Types.VARCHAR);
		}

		if (employee.getGender().isPresent()) {
			preparedStatement.setString(5, employee.getGender().get().name());
		} else {
			preparedStatement.setNull(5, Types.VARCHAR);
		}

		if (employee.getDepartmentId().isPresent()) {
			preparedStatement.setInt(6, employee.getDepartmentId().get());
		} else {
			preparedStatement.setNull(6, Types.INTEGER);
		}
	}
}