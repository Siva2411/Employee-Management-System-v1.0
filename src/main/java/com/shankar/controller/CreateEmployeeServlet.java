package com.shankar.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.shankar.dao.impl.EmployeeDAOimpl;
import com.shankar.dao.inter.EmployeeDAO;
import com.shankar.enums.Gender;
import com.shankar.model.Employee;
import com.shankar.util.EmployeeUtil;

@WebServlet("/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDAO employeeDAO;

	public CreateEmployeeServlet() {
		super();
		employeeDAO = new EmployeeDAOimpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile_number");
		Gender gender = request.getParameter("gender") == "Male" ? Gender.Male : Gender.Female;
		int departmentid = Integer.parseInt(request.getParameter("dept_id"));
		Employee employee = EmployeeUtil.mapToEmployee(id, name, email, mobile, gender, departmentid);

		boolean status = employeeDAO.saveEmployee(employee);
		RequestDispatcher dispatcher = null;
		if (status) {
			response.sendRedirect("");//pending to redirect
		} else {
			request.setAttribute("errorMessage", "failed to add new employee");
			dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
