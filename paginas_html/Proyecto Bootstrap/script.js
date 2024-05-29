$(document).ready(function() {
    $('#miCarrusel').on('slide.bs.carousel', function (e) {
        var nextH = $(e.relatedTarget).height();
        $(this).find('.active.carousel-item').parent().animate({ height: nextH }, 500);
    });
});