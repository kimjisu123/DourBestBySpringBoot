// 비밀번호 확인
$('#newPwd, #pwdCheck').on('keyup', function () {
    const pwd = $('#newPwd').val();
    const pwdcheck = $('#pwdCheck').val();
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

$('#pwdButton').click(function (event){
    let pwdform = $('#changePwdForm');
    let pwd = $('#newPwd').val();
    let checkPw = $('#pwdCheck').val();
    let check_pwd =   /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;




    // 비밀번호 공백 확인
    if ( pwd == "" || pwd == null) {
        alert ('비밀번호를 입력해주세요.');
        $('#newPwd').focus();
        event.preventDefault();

    }

    // 비밀번호 유효성 체크
    if (!check_pwd.test(pwd)) {
        alert ('영문 및 숫자, 특수문자를 포함한 비밀번호를 입력해주세요.');
        $('#newPwd').val("");
        $('#newPwd').focus();
        event.preventDefault();

    }

    // 비밀번호 일치성 체크
    if (pwd != checkPw) {
        alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');
        $('#pwd').val("");
        $('#pwdCheck').val("");
        $('#pwd').focus();
        event.preventDefault();

    }

});




$('#button2').click(function (event){

    var result = confirm("정말로 탈퇴하시겠습니까?");
    if(result){

        alert("탈퇴가 완료되었습니다.");
        return result;

    } else {

        alert("서비스를 이용해주셔서 감사합니다.");
        return result;
    }


});