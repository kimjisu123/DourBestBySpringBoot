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
            document.getElementById("ditailadress").focus();
        }
    }).open();
}



// 아이디 중복 체크

         function idCheck(){

            var memberId = $("#memberId").val(); // 변수 넣기
            var idRegExp = /^[a-zA-Z0-9_-]{5,20}$/;   // 영어 대소문자 및 숫자 4~12자리를 입력한 아이디만 가능
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







































