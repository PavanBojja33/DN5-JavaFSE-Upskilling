document.getElementById("regForm").addEventListener("submit", function(event) {
  event.preventDefault();

  const form = event.target;
  const userName = form.elements["userName"].value;
  const email = form.elements["email"].value;
  const statusEl = document.getElementById("status");

  statusEl.textContent = "Submitting...";

  setTimeout(function() {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userName, email })
    })
      .then(function(response) { return response.json(); })
      .then(function(data) {
        statusEl.textContent = "Registration successful! ID: " + data.id;
      })
      .catch(function() {
        statusEl.textContent = "Registration failed. Please try again.";
      });
  }, 1500);
});
