<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register</title>

    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/register.css" />
  </head>
  <body>
    <div
      class="register-container d-flex justify-content-center align-items-center min-vh-100"
    >
      <div class="register-card p-4">
        <h2 class="text-center mb-4">Register</h2>
        <form id="registerForm" novalidate>
          <div class="mb-3 form-group">
            <input
              type="text"
              class="form-control"
              placeholder="Username"
              id="username"
              required
            />
            <div class="invalid-feedback">Username must start with a capital letter, be 6-10 characters long, and only contain alphanumeric characters.</div>
          </div>
          <div class="mb-3 form-group">
            <input
              type="email"
              class="form-control"
              placeholder="E-mail"
              id="email"
              required
            />
            <div class="invalid-feedback">Please enter a valid email address.</div>
          </div>
          <div class="mb-3 position-relative form-group">
            <input
              type="password"
              class="form-control"
              placeholder="Password"
              id="password"
              required
            />
            <i
              class="fa fa-eye position-absolute toggle-password password-icon-style"
              id="togglePassword"
            ></i>
            <div class="invalid-feedback">Password must be 6 characters, contain at least one letter,number, and special character.</div>
          </div>
          <div class="mb-3 form-group position-relative">
            <input
              type="password"
              class="form-control"
              placeholder="Confirm Password"
              id="confirmPassword"
              required
            />
            <i
              class="fa fa-eye position-absolute toggle-password password-icon-style"
              id="toggleConfirmPassword"
            ></i>
            <div class="invalid-feedback">Passwords do not match.</div>
          </div>
          <button type="submit" class="btn btn-primary w-100 mb-2">
            Register
          </button>
          <a href="./login.html" class="text-center d-block have-account"
            >Have an account? Sign In</a
          >
        </form>
      </div>
    </div>
    <script src="./js/validateRegister.js"></script>
    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
