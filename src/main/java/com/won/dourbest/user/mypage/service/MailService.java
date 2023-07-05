package com.won.dourbest.user.mypage.service;

import com.won.dourbest.common.exception.member.MailNotFoundException;
import com.won.dourbest.user.dao.MemberMapper;
import com.won.dourbest.user.dto.CheckMemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;
    private final MemberMapper mapper;
    private final PasswordEncoder passwordEncoder;


    public String createCode(){

        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(3);

            switch (index) {
                case 0 :
                    key.append((char) ((int)random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) ((int)random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        return key.toString();
    }

    public MimeMessage createEmailForm(String email, String code, String division) throws MessagingException {

        String setFrom = "ddj04323@naver.com";
        String toEmail = email; //받는 사람

        String title = division.equals("id")?"DOURBEST 아이디 찾기 전송" : "DOURBEST 비밀번호 재설정";

        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, toEmail); //보낼 이메일 설정
        message.setSubject(title); //제목 설정
        message.setFrom(setFrom); //보내는 이메일
        message.setText(setContext(code, division),"utf-8", "html");

        return message;
    }

    @Transactional
    public String sendMail(String toEmail, String division) throws MessagingException {

        if(division.equals("id")){
            String byEmail = mapper.findByEmail(toEmail).orElseThrow(()-> new MailNotFoundException("해당되는 메일이 없습니다."));

            MimeMessage emailForm = createEmailForm(toEmail, byEmail, division);

            emailSender.send(emailForm);

            return byEmail;
        }

        else if(division.equals("pwd")){
            mapper.findByEmail(toEmail).orElseThrow(()-> new MailNotFoundException("해당되는 메일이 없습니다."));

            String code = createCode();

            mapper.updatePwd(new CheckMemberDTO(toEmail, passwordEncoder.encode(code)));

            MimeMessage emailForm = createEmailForm(toEmail, code, division);

            emailSender.send(emailForm);
            return code;
        }
        return "";
    }

    public String setContext(String code, String division) {
        Context context = new Context();
        context.setVariable("code", code);

        if(division.equals("pwd")){
            return templateEngine.process("pwdAnswer", context); //pwdAnswer.html
        }


        return templateEngine.process("idAnswer", context); //idAnswer.html
    }

}
