package com.shankar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.shankar.dao.impl.EmployeeDAOimpl;
import com.shankar.dao.inter.EmployeeDAO;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public DeleteEmployeeServlet() {
		super();
		employeeDAO = new EmployeeDAOimpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		employeeDAO = new EmployeeDAOimpl();

		if (employeeDAO.deleteEmployee(id)) {
			response.sendRedirect("employee?action=list");
		} else {
			request.setAttribute("errorMessage", "Failed to delete employee.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
