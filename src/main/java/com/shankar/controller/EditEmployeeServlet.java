package com.shankar.controller;

import java.io.IOException;

import com.shankar.dao.impl.EmployeeDAOimpl;
import com.shankar.dao.inter.EmployeeDAO;
import com.shankar.enums.Gender;
import com.shankar.model.Employee;
import com.shankar.util.EmployeeUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
   
    public EditEmployeeServlet() {
        super();
        employeeDAO = new EmployeeDAOimpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile_number");
		Gender gender = request.getParameter("gender") == "Male" ? Gender.Male : Gender.Female;
		int departmentid = Integer.parseInt(request.getParameter("dept_id"));
		Employee employee = EmployeeUtil.mapToEmployee(id, name, email, mobile, gender, departmentid);
		boolean status = employeeDAO.updateEmployee(id, employee);
		if(status) {
			response.sendRedirect("employee?action=list");
		}
		else {
	           request.setAttribute("errorMessage", "Failed to update employee.");
	           request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
