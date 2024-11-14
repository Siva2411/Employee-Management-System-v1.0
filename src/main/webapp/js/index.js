document.addEventListener("DOMContentLoaded", function () {
  // Select all nav-link items
  const navItems = document.querySelectorAll(".nav-link");

  navItems.forEach((navItem) => {
    navItem.addEventListener("click", function (event) {
      event.preventDefault(); // Prevent default link behavior

      // Get the data-section value which corresponds to the section ID
      const sectionId = this.getAttribute("data-section");

      // Call function to display the correct section
      showContent(sectionId);
    });
  });

  // Form validation logic
  var forms = document.querySelectorAll('.needs-validation');
  forms.forEach((formElement) => {
    formElement.addEventListener('submit', function (event) {
      if (!this.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }
      this.classList.add('was-validated'); // Corrected method name
    }, false);
  });
});

function showContent(sectionId) {
  // Hide all content sections
  const sections = document.querySelectorAll(".content-section");
  sections.forEach((section) => {
    section.style.display = "none";
  });

  // Show the selected section
  const activeSection = document.getElementById(sectionId);
  if (activeSection) {
    activeSection.style.display = "block";
  }
}