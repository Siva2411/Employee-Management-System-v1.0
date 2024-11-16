package com.shankar.controller;

import java.io.IOException;
import java.util.List;

import com.shankar.dao.impl.EmployeeDAOimpl;
import com.shankar.dao.inter.EmployeeDAO;
import com.shankar.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listEmployee")
public class ReadEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao;

	public ReadEmployeeServlet() {
		super();
		dao = new EmployeeDAOimpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("list")) {
			List<Employee> employees = readAllEmployees();
			RequestDispatcher dispatcher = null;
			if (employees != null) {
				request.setAttribute("employees", employees);
				dispatcher = request.getRequestDispatcher("employee-view-list.jsp");
				dispatcher.forward(request, response);
			}
			request.setAttribute("error message", "unable to get employees list");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			Employee employee = readEmployee(id);
			RequestDispatcher dispatcher = null;
			if (employee != null) {
				request.setAttribute("employee", employee);
				dispatcher = request.getRequestDispatcher("employee-view.jsp.jsp");
				dispatcher.forward(request, response);
			}
			request.setAttribute("error message", "employee does not exist with id "+id);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

	private List<Employee> readAllEmployees() {
		List<Employee> employees = dao.findAllEmployees();
		return employees;
	}
	private Employee readEmployee(int id) {
		Employee employee = dao.findEmployeeById(id);
		return employee;
	}
}
