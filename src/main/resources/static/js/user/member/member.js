function memberCheck(){

    var pwd = $("#pwd").val(); // 변수 넣기
    const output = document.querySelector('#pwd-error');
    console.log(pwd);

    if(pwd.length > 0) { // .test 문자열이 일치하는지 확인함.

        console.log(pwd);

        $.ajax({
            url: "/user/mypage/checkMember",
            type: "post",
            data: { pwd: pwd },
            success: function (data) {

                console.log(data);
                if (data == "success") {

                    $(location).attr("href", "/user/mypage/changeInfo")


                } else {

                    $(location).attr("href", "/user/mypage/checkMember")
                }
            }, error: function () {
                console.log(data)

            }

        });
    } else{

        output.textContent ='이메일을 입력하지 않았거나 잘못된 형식으로 입력하셨습니다.'
        output.style.color = 'red'
        document.getElementById("pwd").focus();

        return false;
    }

}