$(function(){
    $('.contents > div').hide();
    $('.tabnav a').click(function () {
        $('.contents > div').hide().filter(this.hash).fadeIn();
        $('.tabnav a').removeClass('active');
        $(this).addClass('active');
        return false;
    }).filter(':eq(0)').click();
});