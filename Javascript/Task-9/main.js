function renderEvents(events) {
  const ul = document.getElementById("eventList");
  ul.innerHTML = "";
  events.forEach(function(e) {
    const li = document.createElement("li");
    li.textContent = `${e.name} - ${e.category} (${e.date})`;
    ul.appendChild(li);
  });
}

function loadWithPromise() {
  fetch("events.json")
    .then(function(response) { return response.json(); })
    .then(function(data) { renderEvents(data); })
    .catch(function(err) { console.error("Error:", err); });
}

async function loadWithAsync() {
  document.getElementById("spinner").style.display = "block";
  try {
    const response = await fetch("events.json");
    const data = await response.json();
    renderEvents(data);
  } catch (err) {
    console.error("Error:", err);
  } finally {
    document.getElementById("spinner").style.display = "none";
  }
}
