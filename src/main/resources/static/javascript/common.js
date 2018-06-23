$(document).ready(function () {
    $(".movie-list-card").hover(function() {
        $(this).children(".card-img-top").css("box-shadow", "0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22)")
    }, function() {
        $(this).children(".card-img-top").css("box-shadow", "none");
    });

    $(".video-list-card").hover(function() {
        $(this).children(".card-body").children().css("text-decoration", "underline")
    }, function() {
        $(this).children(".card-body").children().css("text-decoration", "none")
    });

    $(".href").on("click", function() {
        window.location.href = $(this).data("href").toString();
    });
});