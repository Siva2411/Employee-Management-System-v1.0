package com.shankar.dao.inter;

import java.util.List;

import com.shankar.model.Department;

public interface DepartmentDAO {
	public abstract List<Department> findAllDepartments();
	public abstract Department findDepartmentById(int departmentId);
	public abstract void saveDepartment(Department department);
	public abstract void updateDepartment(int departmentId,Department department);
	public abstract void deleteDepartment(int departmentId);
}
