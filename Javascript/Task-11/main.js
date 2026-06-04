document.getElementById("registrationForm").addEventListener("submit", function(event) {
  event.preventDefault();

  const form = event.target;
  const userName = form.elements["userName"].value.trim();
  const email = form.elements["email"].value.trim();
  const selectedEvent = form.elements["event"].value;

  document.getElementById("nameError").textContent = "";
  document.getElementById("emailError").textContent = "";
  document.getElementById("eventError").textContent = "";

  let valid = true;

  if (!userName) {
    document.getElementById("nameError").textContent = "Name is required.";
    valid = false;
  }

  if (!email || !email.includes("@")) {
    document.getElementById("emailError").textContent = "Valid email is required.";
    valid = false;
  }

  if (!selectedEvent) {
    document.getElementById("eventError").textContent = "Please select an event.";
    valid = false;
  }

  if (valid) {
    document.getElementById("successMsg").textContent = `Registered: ${userName} for ${selectedEvent}`;
  }
});
