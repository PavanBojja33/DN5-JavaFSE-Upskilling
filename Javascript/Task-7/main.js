const events = [
  { name: "Music Fest", seats: 10 },
  { name: "Art Show", seats: 5 }
];

const container = document.querySelector("#eventsContainer");

events.forEach(function(event, index) {
  const card = document.createElement("div");
  card.style.border = "1px solid #ccc";
  card.style.margin = "10px";
  card.style.padding = "10px";

  const title = document.createElement("h3");
  title.textContent = event.name;

  const seats = document.createElement("p");
  seats.id = "seats-" + index;
  seats.textContent = "Seats: " + event.seats;

  const registerBtn = document.createElement("button");
  registerBtn.textContent = "Register";
  registerBtn.onclick = function() {
    if (event.seats > 0) {
      event.seats--;
      seats.textContent = "Seats: " + event.seats;
    } else {
      seats.textContent = "No seats available";
    }
  };

  const cancelBtn = document.createElement("button");
  cancelBtn.textContent = "Cancel";
  cancelBtn.onclick = function() {
    event.seats++;
    seats.textContent = "Seats: " + event.seats;
  };

  card.appendChild(title);
  card.appendChild(seats);
  card.appendChild(registerBtn);
  card.appendChild(cancelBtn);
  container.appendChild(card);
});
