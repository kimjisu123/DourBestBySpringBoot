package com.won.dourbest.admin.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
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


}
