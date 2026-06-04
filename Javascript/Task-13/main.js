document.getElementById("debugForm").addEventListener("submit", function(event) {
  event.preventDefault();

  const form = event.target;
  const userName = form.elements["userName"].value;
  const email = form.elements["email"].value;

  console.log("Step 1: Form submitted");
  console.log("Step 2: User Name =", userName);
  console.log("Step 3: Email =", email);

  const payload = { userName, email };
  console.log("Step 4: Payload =", JSON.stringify(payload));

  debugger;

  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(payload)
  })
    .then(function(response) {
      console.log("Step 5: Response status =", response.status);
      return response.json();
    })
    .then(function(data) {
      console.log("Step 6: Response data =", data);
      document.getElementById("debugStatus").textContent = "Success! Check the Console and Network tab in DevTools.";
    })
    .catch(function(err) {
      console.error("Step 7: Fetch error =", err);
      document.getElementById("debugStatus").textContent = "Error occurred. Check console.";
    });
});
