// Form validation
document
  .getElementById("loginForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    // Get form fields
    const username = document.getElementById("username");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");

    let isValid = true;

    // Username validation
    const usernameRegex = /^[A-Z][a-zA-Z0-9]{5,9}$/;
    if (!usernameRegex.test(username.value)) {
      username.classList.add("is-invalid");
      isValid = false;
    } else {
      username.classList.remove("is-invalid");
    }

    // Password validation
    const passwordRegex =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6}$/;
    if (!passwordRegex.test(password.value)) {
      password.classList.add("is-invalid");
      isValid = false;
    } else {
      password.classList.remove("is-invalid");
    }

    // Confirm password validation
    if (password.value !== confirmPassword.value) {
      confirmPassword.classList.add("is-invalid");
      isValid = false;
    } else {
      confirmPassword.classList.remove("is-invalid");
    }

    return isValid;
  });
