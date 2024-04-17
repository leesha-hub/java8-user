package dev.lsh.java8user.member.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberListResponseDTO {
    private String memId;
    private String memPw;
    private String nickname;
    private String memName;
    private String phone;
    private String email;
    private LocalDateTime insertDateTime;

    public MemberListResponseDTO(String memId, String memPw, String nickname, String memName, String phone, LocalDateTime insertDateTime) {
        this.memId = memId;
        this.memPw = memPw;
        this.nickname = nickname;
        this.memName = memName;
        this.phone = phone;
        this.email = email;
        this.insertDateTime = insertDateTime;
    }
}