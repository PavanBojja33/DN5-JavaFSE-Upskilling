let events = [
  { name: "Baking Workshop", category: "Food" },
  { name: "Jazz Night", category: "Music" },
  { name: "Rock Concert", category: "Music" }
];

function render(list) {
  const ul = document.getElementById("output");
  ul.innerHTML = "";
  list.forEach(function(e) {
    const li = document.createElement("li");
    li.textContent = e;
    ul.appendChild(li);
  });
}

function addNew() {
  const name = document.getElementById("newEventName").value;
  const category = document.getElementById("newEventCategory").value;
  events.push({ name, category });
  render(events.map(function(e) { return `${e.category} - ${e.name}`; }));
}

function showMusic() {
  const music = events.filter(function(e) { return e.category === "Music"; });
  render(music.map(function(e) { return e.name; }));
}

function showFormatted() {
  const cards = events.map(function(e) { return `${e.category} on ${e.name}`; });
  render(cards);
}
