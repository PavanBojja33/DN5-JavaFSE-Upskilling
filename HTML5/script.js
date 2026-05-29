function validatePhone() {
  let phone = document.getElementById("phone").value;

  if (phone.length != 10 || isNaN(phone)) {
    alert("Enter a 10-digit phone number");
  }
}

function submitForm() {
  event.preventDefault();
  alert("Form Submitted Successfully");
}

function count() {
  let text = document.getElementById("feedback").value;

  let msg = document.getElementById("count");
  msg.innerText = "Count : " + text.length;
}

function enlargeImage() {
  let image = document.getElementById("event_img");

  image.style.width = "500px";
  image.style.height = "350px";
}

function dropChange() {
  let event = document.getElementById("type").value;

  let fee = document.getElementById("event-fee");

  let image = document.getElementById("event_img");

  if (event === "dance") {
    fee.innerText = "Event Fee : ₹500";

    image.src =
      "https://th.bing.com/th/id/OIP.66kIhSObnBKvSf8PhskvRAHaE5?w=267&h=180&c=7&r=0&o=7&dpr=1.3&pid=1.7&rm=3";
  } else if (event === "music") {
    fee.innerText = "Event Fee : ₹700";

    image.src =
      "https://th.bing.com/th/id/OIP.j00Rvw-O84CNvxIjOtGe2wHaE8?w=261&h=180&c=7&r=0&o=7&dpr=1.3&pid=1.7&rm=3";
  } else if (event === "racing") {
    fee.innerText = "Event Fee : ₹1000";

    image.src =
      "https://www.supercars.net/blog/wp-content/uploads/2016/06/Le-Mans-2015-car-group-shot.jpg";
  } else if (event === "fashion") {
    fee.innerText = "Event Fee : ₹800";

    image.src =
      "https://wwd.com/wp-content/uploads/2025/11/BOSS_Spring_Summer_26_Fashion_Show_RUNWAY_FINALE_006_16x9__image-mid-res.jpeg?resize=225";
  } else if (event === "sports") {
    fee.innerText = "Event Fee : ₹600";

    image.src =
      "https://wallpapers.com/images/hd/olympic-sports-running-event-x1y80cstihlla4bo.jpg";
  } else {
    fee.innerText = "Event Fee : ₹400";

    image.src =
      "https://paintingandvino.com/wp-content/uploads/2022/01/P_V_2.jpg";
  }
}

let watchedVideo = false;

function videoReady() {
  document.getElementById("video-msg").innerText = "Video ready to play";
  watchedVideo = true;
}

window.onbeforeunload = function () {
  if (!watchedVideo) {
    return "Please watch the event promo video before leaving.";
  }
};

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