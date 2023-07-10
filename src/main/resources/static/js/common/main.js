const list = document.querySelectorAll('.header-bottom ul li');
const indicator = document.querySelector('.indicator');

function changeIndicator(target){
    indicator.style.left = target.offsetLeft + 'px';
    indicator.style.width = target.offsetWidth + 'px';
}

list.forEach((item) => {
    item.addEventListener('click', (event)=>{
        changeIndicator(event.target)
    });
});

// const likebt = document.querySelector('.like svg');
// console.log(likebt);

$('#btnCreate').click(function(){
    let couponName = $('.couponName').val();
    let couponContent = $('.couponContent').val();
    let couponDiscount = $('.couponDiscount').val();
    let couponVaildDate = $('.couponVaildDate').val();


    let couponRegist = {
        couponName,
        couponContent,
        couponDiscount,
        couponVaildDate
    }

    $.ajax({
        url : "/admin/Issuance",
        type : "POST",
        contentType : "application/json",
        data : JSON.stringify(couponRegist),
        success : function (data) {
            console.log(data);
            alert(data);
            $('.contactmodal').css('display', 'none');
            window.location.reload();
        },
        error : function (error) {
            console.log(error);
            alert(error);
            $('.contactmodal').css('display', 'none');
            window.location.reload();
        }
    })
});

const contactmodal = document.querySelector(".contactmodal");
const btn = document.querySelector(".contactBtn");
const $span = document.querySelector(".close");


btn.addEventListener('click', openContactModal);
$span.addEventListener('click', closeContactModal);

function openContactModal() {
    contactmodal.style.display = "block";
    contactmodal.animate([{opacity: 0}, {opacity: 1}], {duration: 300, fill: "forwards"});
}

function closeContactModal() {
    contactmodal.animate([{opacity: 1}, {opacity: 0}], {duration: 300, fill: "forwards"}).onfinish = function() {
        contactmodal.style.display = "none";
        const $img = document.querySelector(".contact-imgdiv");
        if($img.hasChildNodes()){
            $img.replaceChildren();
        }
    };
}

function contactreadURL(obj) {

    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let $div = $('<div>');
        $($div).css('width','120px');
        $($div).css('height','120px');
        $($div).css('padding','10px 10px 0px 0px');

        $('.contact-imgdiv').append($div);

        let img = $('<img />');
        $(img).attr('src', e.target.result);
        $(img).css('width','100%');
        $(img).css('height','100%');
        $($div).append(img);
    }
}