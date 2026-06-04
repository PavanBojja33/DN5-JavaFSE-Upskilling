let events = [];

function categoryTracker() {
  let count = 0;
  return function() {
    count++;
    return count;
  };
}

const trackMusic = categoryTracker();

function addEvent() {
  const name = document.getElementById("eventName").value;
  const category = document.getElementById("eventCategory").value;
  events.push({ name, category });
  renderEvents(events);
}

function registerUser(event) {
  if (event.category === "Music") {
    const total = trackMusic();
    document.getElementById("registrationCount").textContent = `Music registrations: ${total}`;
  }
}

function filterEventsByCategory(list, callback) {
  return list.filter(callback);
}

function filterEvents() {
  const cat = document.getElementById("filterCategory").value;
  const filtered = filterEventsByCategory(events, function(e) {
    return e.category.toLowerCase() === cat.toLowerCase();
  });
  renderEvents(filtered);
}

function renderEvents(list) {
  const ul = document.getElementById("eventList");
  ul.innerHTML = "";
  list.forEach(function(e) {
    const li = document.createElement("li");
    li.textContent = `${e.name} (${e.category})`;
    li.onclick = function() { registerUser(e); };
    ul.appendChild(li);
  });
}
