package com.won.dourbest.admin.account.dto;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
public class AdminImpl extends User{

    private int adminCode;
    private String adminEmail;
    private Date regiDate;
    private String adminPhone;
    private String adminName;
    private String adminPwd;

    private List<AdminAuthListDTO> adminAuthList;

    public AdminImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setDetail(AdminAccountDTO account){
        this.adminCode = account.getAdminCode();
        this.adminEmail = account.getAdminEmail();
        this.regiDate = account.getRegiDate();
        this.adminPhone = account.getAdminPhone();
        this.adminName = account.getAdminName();
        this.adminPwd = account.getAdminPwd();
    }


}
