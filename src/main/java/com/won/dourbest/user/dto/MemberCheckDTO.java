package com.won.dourbest.user.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


// 회원가입 시 유효성 검사할 멤버 DTO //
@Getter
@NoArgsConstructor
public class MemberCheckDTO {


    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    private String memberName;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String memberEmail;

    @NotEmpty( message = "비밀번호는 필수 입력 값입니다.")
    @Length(min =8 , max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

    // 매개변수 생성자
    @Builder
    public MemberCheckDTO(String memberName, String memberEmail, String password, String address) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.password = password;
        this.address = address;
    }
}
