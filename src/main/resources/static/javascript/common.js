$(document).ready(function () {
  $(".movie-list-card").hover(function () {
    $(this).children(".card-img-top").css("box-shadow", "0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22)")
  }, function () {
    $(this).children(".card-img-top").css("box-shadow", "none");
  });

  $(".video-list-card").hover(function () {
    $(this).children(".card-body").children().css("text-decoration", "underline")
  }, function () {
    $(this).children(".card-body").children().css("text-decoration", "none")
  });

  $(".href").on("click", function () {
    window.location.href = $(this).data("href").toString();
  });

  /**
   * Sign In / Up
   */
  $('#sign_up_form').on('submit', function (event) {
    event.preventDefault();
    var signUpObject = signUpValidation($(this));
    if (Object.keys(signUpObject).length === 4) {
      $.ajax({
        url: '/user/sign-up',
        type: 'POST',
        contentType : "application/json; charset=UTF-8",
        data: JSON.stringify(signUpObject),
        beforeSend: function (xhr, settings) {
          var token = $("meta[name='_csrf']").attr("content");
          var header = $("meta[name='_csrf_header']").attr("content");
          xhr.setRequestHeader(header, token);
        },
        success: function(response) {
          if (response['status'] === 'fail') {
            alert(response['message']);
          }
          if (response['status'] === 'success') {
            console.log(response['data']);
            window.location.href = '/user/sign-in';
          }
        },
        error: function () {
          alert("다시 시도해주세요.");
        }
      });
    }
  });

  $('#sign_in_password_not_match').show();
  $('#sign_in_form').on('submit', function (event) {
    event.preventDefault();

    var signInObject = signInValidation($(this));
    if (Object.keys(signInObject).length === 2) {
      $.ajax({
        url: '/user/validation?userId=' + signInObject.userId,
        beforeSend: function (xhr, settings) {
          var token = $("meta[name='_csrf']").attr("content");
          var header = $("meta[name='_csrf_header']").attr("content");
          xhr.setRequestHeader(header, token);
        },
        success: function(response) {
          if (response['status'] === 'fail') {
            $("#sign_in_id_not_registered").show();
            return false;
          }
          event.currentTarget.submit();
        },
        error: function () {
          alert("다시 시도해주세요.");
        }
      });
    }
  });
});

/**
 * Sign In / Up
 */
function signPageMove(target) {
  var location = window.location;
  if (target === 'sign-up') {
    return location.href = '/user/sign-up';
  }
  if (target === 'sign-in') {
    return location.href = '/user/sign-in';
  }
}

function signUpValidation($this) {
  var formObject = {};

  // invalid init
  $this.find('input').each(function (key) {
    var $invalid = $('#' + $(this).prop('id') + '_invalid');
    $invalid.hide();
  });

  if ($this.find('#user_id').val() !== '') {
    formObject.userId = $this.find('#user_id').val();
  } else {
    $('#user_id_invalid').show();
  }

  if ($this.find('#user_nickname').val() !== '') {
    formObject.userNickname = $this.find('#user_nickname').val();
  } else {
    $('#user_nickname_invalid').show();
  }

  if ($this.find('#user_password').val() !== '') {
    formObject.userPassword = $this.find('#user_password').val();
  } else {
    $('#user_password_invalid').show();
  }

  if ($this.find('#user_password_confirm').val() !== '' && formObject.userPassword &&
    $this.find('#user_password_confirm').val() === formObject.userPassword) {
    formObject.userPasswordConfirm = $this.find('#user_password_confirm').val();
  } else {
    $('#user_password_confirm_invalid').show();
  }

  return formObject;
}

function signInValidation($this) {
  var formObject = {};

  // invalid init
  $(".invalid-feedback").hide();

  if ($this.find('#user_id').val() !== '') {
    formObject.userId = $this.find('#user_id').val();
  } else {
    $('#sign_in_id_invalid').show();
  }

  if ($this.find('#user_password').val() !== '') {
    formObject.userPassword = $this.find('#user_password').val();
  } else {
    $('#sign_in_password_invalid').show();
  }

  return formObject;
}