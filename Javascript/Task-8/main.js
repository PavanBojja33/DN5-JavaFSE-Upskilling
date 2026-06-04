const events = [
  { name: "Jazz Night", category: "Music" },
  { name: "Baking Workshop", category: "Food" },
  { name: "Art Fair", category: "Art" },
  { name: "Rock Concert", category: "Music" }
];

function renderEvents(list) {
  const container = document.getElementById("eventsContainer");
  container.innerHTML = "";
  list.forEach(function(event) {
    const card = document.createElement("div");
    card.style.border = "1px solid #aaa";
    card.style.margin = "8px";
    card.style.padding = "8px";

    const title = document.createElement("span");
    title.textContent = `${event.name} (${event.category}) `;

    const btn = document.createElement("button");
    btn.textContent = "Register";
    btn.onclick = function() {
      alert("Registered for " + event.name);
    };

    card.appendChild(title);
    card.appendChild(btn);
    container.appendChild(card);
  });
}

renderEvents(events);

function filterByCategory() {
  const selected = document.getElementById("categoryFilter").value;
  if (selected === "All") {
    renderEvents(events);
  } else {
    renderEvents(events.filter(function(e) { return e.category === selected; }));
  }
}

document.getElementById("searchInput").addEventListener("keydown", function(e) {
  const query = e.target.value.toLowerCase();
  renderEvents(events.filter(function(ev) { return ev.name.toLowerCase().includes(query); }));
});
