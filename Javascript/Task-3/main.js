const events = [
  { name: "Music Fest", date: "2026-07-15", seats: 10, past: false },
  { name: "Old Fair", date: "2025-01-01", seats: 5, past: true },
  { name: "Art Show", date: "2026-08-20", seats: 0, past: false }
];

const list = document.getElementById("eventList");

events.forEach(function(event) {
  if (!event.past && event.seats > 0) {
    const li = document.createElement("li");
    li.textContent = `${event.name} - ${event.date} (Seats: ${event.seats})`;
    list.appendChild(li);
  }
});

function tryRegister(index) {
  try {
    const event = events[index];
    if (event.seats <= 0) {
      throw new Error("No seats available for " + event.name);
    }
    if (event.past) {
      throw new Error("Cannot register for a past event.");
    }
    event.seats--;
    document.getElementById("message").textContent = `Registered for ${event.name}. Seats left: ${event.seats}`;
  } catch (e) {
    document.getElementById("message").textContent = "Error: " + e.message;
  }
}
