const eventName = "Community Music Fest";
const eventDate = "2026-07-15";
let seats = 50;

document.getElementById("eventInfo").textContent = `Event: ${eventName} | Date: ${eventDate}`;
document.getElementById("seats").textContent = seats;

function register() {
  seats--;
  document.getElementById("seats").textContent = seats;
}

function cancel() {
  seats++;
  document.getElementById("seats").textContent = seats;
}
