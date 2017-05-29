
$(document).on("click", ".like-btn", function(e) {
    e.preventDefault();

    var $badge = $(this).find('.badge'),
        count = Number($badge.text()),
        active = $(this).hasClass('active');


    if ($(this).hasClass('active')) {
        $badge.text(count-1);
        document.getElementById("1").style.borderColor = "#C0C0C0";
    }
    else {
        $badge.text(count+1);
        document.getElementById("1").style.borderColor = "#6fe300";
    }
    $(this).toggleClass('active');


});


$(document).on("click", ".unlike-btn", function(e) {
    e.preventDefault();

    var $badge = $(this).find('.badge'),
        count = Number($badge.text()),
        active = $(this).hasClass('active');


    if ($(this).hasClass('active')) {
        $badge.text(count-1);
        document.getElementById("2").style.borderColor = "#C0C0C0";
    }
    else {
        $badge.text(count+1);
        document.getElementById("2").style.borderColor = "#E34234";
    }
    $(this).toggleClass('active');


});
