const events = [
  { name: "Jazz Night", category: "Music", date: "2026-07-15" },
  { name: "Baking Workshop", category: "Food", date: "2026-08-01" },
  { name: "Rock Concert", category: "Music", date: "2026-09-10" }
];

function filterEvents(list = [], category = "Music") {
  const cloned = [...list];
  return cloned.filter(e => e.category === category);
}

function showFiltered() {
  const cat = document.getElementById("filterInput").value || "Music";
  const result = filterEvents(events, cat);
  const ul = document.getElementById("output");
  ul.innerHTML = "";
  result.forEach(e => {
    const { name, category, date } = e;
    const li = document.createElement("li");
    li.textContent = `${name} | ${category} | ${date}`;
    ul.appendChild(li);
  });
}

showFiltered();
