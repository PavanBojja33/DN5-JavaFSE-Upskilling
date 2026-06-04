$(document).ready(function() {
  var visible = true;

  $('#registerBtn').click(function() {
    alert("Registered via jQuery!");
  });

  $('#toggleBtn').click(function() {
    if (visible) {
      $('.eventCard').fadeOut();
      visible = false;
    } else {
      $('.eventCard').fadeIn();
      visible = true;
    }
  });
});
