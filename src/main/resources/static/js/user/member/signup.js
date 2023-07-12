/* 주소 검색 자바 스크립트 */
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("adress").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailadress").focus();
        }
    }).open();
}



// 아이디 중복 체크

         function idCheck(){

            var memberId = $("#memberId").val(); // 변수 넣기
            var idRegExp = /^[a-zA-Z0-9_-]{6,20}$/;   // 영어 대소문자 및 숫자 4~12자리를 입력한 아이디만 가능
            const output = document.querySelector('#id-error');
            console.log(memberId);

            if(memberId.length > 0 && idRegExp.test(memberId) == true) {

                 $.ajax({
                     url: "/user/checkId",
                     type: "post",
                     data: {memberId: memberId},
                     success: function (data) {

                         console.log(data);
                         if (data == "success") {


                             output.textContent = '사용 가능한 아이디 입니다.'
                             output.style.color = 'green'

                         } else {
                             output.textContent = '사용 중인 아이디 입니다.'
                             output.style.color = 'red'
                         }
                     }, error: function () {
                         console.log(data)

                     }

                 });
             } else {
                output.textContent ='아이디를 입력하지 않았거나 입력형식이 잘못되었습니다.대소문자와숫자 4~12자리입력'
                output.style.color = 'red'
                document.getElementById("memberId").focus();

                return false;
            }
        }

        // email 중복체크
        function emailCheck(){

            var memberEmail = $("#memberEmail").val(); // 변수 넣기
            var exptext =/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;  // 이메일의 형식을 처리하는 기능
            const output = document.querySelector('#email-error');

            console.log(memberEmail);

            if(memberEmail.length > 0 && exptext.test(memberEmail) == true) { // .test 문자열이 일치하는지 확인함.

                console.log(memberEmail);

                $.ajax({
                    url: "/user/checkEmail",
                    type: "post",
                    data: {memberEmail: memberEmail},
                    success: function (data) {

                        console.log(data);
                        if (data == "success") {


                            output.textContent ='사용 가능한 이메일 입니다.'
                            output.style.color = 'green'
                            

                        } else {

                            output.textContent ='이미 사용중인 이메일 입니다.'
                            output.style.color = 'red'
                        }
                    }, error: function () {
                        console.log(data)

                    }

                    });
            } else{

                output.textContent ='이메일을 입력하지 않았거나 잘못된 형식으로 입력하셨습니다.'
                output.style.color = 'red'
                document.getElementById("memberEmail").focus();

                return false;
            }

        }

        // 비밀번호 확인
        $('#password, #passwordCheck').on('keyup', function () {
            const pwd = $('#password').val();
            const pwdcheck = $('#passwordCheck').val();
            const output = document.querySelector('#pwd-error');
            const output2 = document.querySelector('#pwdCheck-error');
            const exptext =   /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
             
            if(exptext.test(pwd)) {

                     console.log(pwd);
                     $('#pwd-error').html('Matching').css('color', 'green');
                     output.textContent = '비밀번호 형식이 맞습니다.'

                    if (pwd == pwdcheck) {

                        $('#pwdCheck-error').html('Matching').css('color', 'green');
                        output2.textContent = '비밀번호가 일치합니다.'

                    } else {

                        $('#pwdCheck-error').html('Not Matching').css('color', 'red');
                        output2.textContent = '비밀번호가 일치하지않습니다.'

                    }

                } else {

                $('#pwd-error').html('Not Matching').css('color', 'red');
                output.textContent ='최소 8자 이상 영문,숫자 특수문자 포함'
                console.log(pwd);
            }
        });


   //이메일 체크

function emailCheck(){

    var memberEmail = $("#memberEmail").val(); // 변수 넣기
    var exptext =/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;  // 이메일의 형식을 처리하는 기능
    const output = document.querySelector('#email-error');

    console.log(memberEmail);

    if(memberEmail.length > 0 && exptext.test(memberEmail) == true) { // .test 문자열이 일치하는지 확인함.

        console.log(memberEmail);

        $.ajax({
            url: "/user/checkEmail",
            type: "post",
            data: {memberEmail: memberEmail},
            success: function (data) {

                console.log(data);
                if (data == "success") {


                    output.textContent ='사용 가능한 이메일 입니다.'
                    output.style.color = 'green'


                } else {

                    output.textContent ='이미 사용중인 이메일 입니다.'
                    output.style.color = 'red'
                }
            }, error: function () {
                console.log(data)

            }

        });
    } else{

        output.textContent ='이메일을 입력하지 않았거나 잘못된 형식으로 입력하셨습니다.'
        output.style.color = 'red'
        document.getElementById("memberEmail").focus();

        return false;
    }

}

// 최종 유효성 검사 한번 더 할 때

//
// $('#signSubmit').click(function (event){
//     let pwdform = $('#changePwdForm');
//     let pwd = $('#newPwd').val();
//     let checkPw = $('#pwdCheck').val();
//     let check_pwd =   /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
//
//
//
//
//     // 비밀번호 공백 확인
//     if ( pwd == "" || pwd == null) {
//         alert ('비밀번호를 입력해주세요.');
//         $('#newPwd').focus();
//         event.preventDefault();
//
//     }
//
//     // 비밀번호 유효성 체크
//     if (!check_pwd.test(pwd)) {
//         alert ('영문 및 숫자, 특수문자를 포함한 비밀번호를 입력해주세요.');
//         $('#newPwd').val("");
//         $('#newPwd').focus();
//         event.preventDefault();
//
//     }
//
//     // 비밀번호 일치성 체크
//     if (pwd != checkPw) {
//         alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');
//         $('#pwd').val("");
//         $('#pwdCheck').val("");
//         $('#pwd').focus();
//         event.preventDefault();
//
//     }
//
// });
//


// 전화번호 유효성 확인
// $('#phone').on('keyup', function () {
//     const phone = $('#phone').val();
//     const output = document.querySelector('#phone-error');
//     const exptext =   /^(?=.*[0-9])[0-9]{8,11}$/;
//
//     if(exptext.test(phone)) {
//
//         console.log(pwd);
//         $('#pwd-error').html('Matching').css('color', 'green');
//         output.textContent = '형식이 맞습니다.'
//
//     } else {
//
//         $('#pwd-error').html('Not Matching').css('color', 'red');
//         output.textContent ='정확하게 입력해주세요.'
//         console.log(pwd);
//     }
// });




//joinform_check 함수로 유효성 검사
function joinform_check() {
    //변수에 담아주기
    var uid = document.getElementById("memberId");
    var pwd = document.getElementById("password");
    var repwd = document.getElementById("passwordCheck");
    var uname = document.getElementById("userName");
    var email = document.getElementById("memberEmail");
    var phone = document.getElementById("phone");
    var postcode = document.getElementById("postcode");
    var adress = document.getElementById("adress");
    var detailadress = document.getElementById("detailadress");
    var agreeAll = document.getElementById("agreeAll");
    // var check1 = document.getElementById("check1");
    // var check2 = document.getElementById("check2");

    if (uid.value == "") { //해당 입력값이 없을 경우 같은말: if(!uid.value)
        alert("아이디를 입력하세요.");
        uid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
        return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
    };

    var idRegExp = /^[a-zA-Z0-9_-]{6,20}$/;

    if (!idRegExp.test(uid.value)) { //해당 입력값이 없을 경우 같은말: if(!uid.value)
        alert("아이디는 대소문자와 숫자 6~20자리 입력.");
        uid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
        return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
    };

    if (pwd.value == "") {
        alert("비밀번호를 입력하세요.");
        pwd.focus();
        return false;
    };

    //비밀번호 영문자+숫자+특수조합(8~20자리 입력) 정규식
    var pwdCheck = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;

    if (!pwdCheck.test(pwd.value)) {
        alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~20자리 사용해야 합니다.");
        pwd.focus();
        return false;
    };

    if (repwd.value !== pwd.value) {
        alert("비밀번호가 일치하지 않습니다.");
        repwd.focus();
        return false;
    };


    if (uname.value == "") {
        alert("이름을 입력하세요.");
        uname.focus();
        return false;
    };

    if (email.value == "") {
        alert("이메일 주소를 입력하세요.");
        email.focus();
        return false;
    }

    var emtext =/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

    if (!emtext.test(email.value)) {
        alert("이메일 형식이 잘못되었습니다.");
        email.focus();
        return false;
    };


    if (phone.value == "") {
        alert(" 휴대폰 번호를 입력하세요.");
        phone.focus();
        return false;
    }

    var reg = /^[0-9]+/g; //숫자만 입력하는 정규식

    if (!reg.test(phone.value)) {
        alert("숫자만 입력할 수 있습니다.");
        phone.focus();
        return false;
    }

    if (postcode.value == "") {
        alert("우편번호를 입력하세요.");
        postcode.focus();
        return false;
    }

    if (adress.value == "") {
        alert("기본 주소를 입력하세요.");
        adress.focus();
        return false;
    }

    if (detailadress.value == "") {
        alert("상세 주소를 입력하세요.");
        detailadress.focus();
        return false;
    }


    if (!agreeAll.checked) { //둘다 미체크시
        alert("약관동의에 체크해주세요.");
        return false;
    }


    //입력 값 전송
    document.signup_form.submit(); //유효성 검사의 포인트

}



//  모달1

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



//  모달2


const contactmodal2 = document.querySelector(".contactmodal2");
const btn2 = document.querySelector(".contactBtn2");
const $span2 = document.querySelector(".close2");


btn2.addEventListener('click', openContactModal2);
$span2.addEventListener('click', closeContactModal2);

function openContactModal2() {
    contactmodal2.style.display = "block";
    contactmodal2.animate([{opacity: 0}, {opacity: 1}], {duration: 300, fill: "forwards"});
}

function closeContactModal2() {
    contactmodal2.animate([{opacity: 1}, {opacity: 0}], {duration: 300, fill: "forwards"}).onfinish = function() {
        contactmodal2.style.display = "none";
        const $img = document.querySelector(".contact-imgdiv");
        if($img.hasChildNodes()){
            $img.replaceChildren();
        }
    };
}






















