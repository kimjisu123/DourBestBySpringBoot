const contactmodal = document.querySelector(".contactmodal");
    const conbtn = document.querySelector(".contactBtn");
    const $conspan = document.querySelector(".contact-close");
    

    conbtn.addEventListener('click', openContactModal);
    $conspan.addEventListener('click', closeContactModal);

    function openContactModal() {
        contactmodal.style.display = "block";
        contactmodal.animate([{opacity: 0}, {opacity: 1}], {duration: 300, fill: "forwards"});
    }

const review = document.querySelector(".reviewmodal");
const contact = document.querySelector(".contactmodal");
    const btn = document.querySelector(".reviewBtn");
    const reviewClose = document.querySelector(".review-close");
    const contactClose = document.querySelector(".contact-close");


    btn.addEventListener('click', openReviewModal);
    reviewClose.addEventListener('click', closeReviewModal);
    contactClose.addEventListener('click', closeContactModal);

    function openReviewModal() {
        review.style.display = "block";
        review.animate([{opacity: 0}, {opacity: 1}], {duration: 300, fill: "forwards"});
    }

    function closeReviewModal() {
        review.animate([{opacity: 1}, {opacity: 0}], {duration: 300, fill: "forwards"}).onfinish = function() {
            review.style.display = "none";
            const $img = document.querySelector(".reviewDiv");
            if($img.hasChildNodes()){
                $img.replaceChildren();
            }
        };
    }
    function closeContactModal() {
        contactmodal.animate([{opacity: 1}, {opacity: 0}], {duration: 300, fill: "forwards"}).onfinish = function() {
            contactmodal.style.display = "none";
        };
    }


    function ReviewreadURL(obj,index) {

        let readers = new FileReader();

        readers.readAsDataURL(obj);
        readers.onload = function (e) {
            let $div = $('<div>');
            $($div).css('width','120px');
            $($div).css('height','120px');
            $($div).css('padding','10px 10px 0px 0px');
            $($div).attr('id','reviewimgId-' + index);
            $($div).attr('onclick','reviewImgDel(' + index + ')');

            $('.reviewDiv').append($div);

            let img = $('<img />');                
            $(img).attr('src', e.target.result);
            $(img).css('width','100%');
            $(img).css('height','100%');
            $($div).append(img);
        }
    }


