function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}

Event.prototype.checkAvailability = function() {
  return this.seats > 0 ? "Available" : "Full";
};

const event1 = new Event("Music Fest", "2026-07-15", 10);
const event2 = new Event("Art Show", "2026-08-20", 0);

const output = document.getElementById("output");

[event1, event2].forEach(function(e) {
  const p = document.createElement("p");
  p.textContent = `${e.name}: ${e.checkAvailability()}`;
  output.appendChild(p);
});

const entries = Object.entries(event1);
const entriesP = document.createElement("p");
entriesP.textContent = "event1 entries: " + entries.map(function(pair) { return pair[0] + "=" + pair[1]; }).join(", ");
output.appendChild(entriesP);
