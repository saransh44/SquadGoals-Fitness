var overview = 720;
var whatWeDo = 1220;
var features = 1598;
var contactUs = 2098;


$(window).bind('scroll', function() {
    var navHeight = 70;
    if ($(window).scrollTop() > navHeight) {
        $('nav').show(300);
    } else {
        $('nav').hide(300);
    }
});

$(".nav").click(function() {
    $(".nav").removeClass("current");
    $(this).addClass("current");
});


