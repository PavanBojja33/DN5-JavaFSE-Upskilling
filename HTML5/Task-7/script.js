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
