function savePreference() {
  let eventType = document.getElementById("preferred-event").value;

  localStorage.setItem("preferredEvent", eventType);

  alert("Preference Saved");
}

window.onload = function () {
  let savedEvent = localStorage.getItem("preferredEvent");

  if (savedEvent) {
    document.getElementById("preferred-event").value = savedEvent;
  }
};

function clearPreferences() {
  localStorage.clear();

  sessionStorage.clear();

  alert("Preferences Cleared");
}
