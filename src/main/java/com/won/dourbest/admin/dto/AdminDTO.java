package com.won.dourbest.admin.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class AdminDTO extends User {
    private int adminCode;
    private String adminEmail;
    private String adminId;
    private String adminPwd;
    private Date regiDate;

    private List<AdminAuthlistDTO> adminAuthlistDTO;
    private List<AdminQnaDTO> adminQnaDTO;
    private List<ContactDTO> contactDTO;

    private List<EventDTO> eventDTO;

    private List<NoticeDTO> noticeDTO;

    private List<BlacklistListDTO> blacklistListDTO;

    private List<ReportResponseDTO> reportResponseDTO;


    public AdminDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
