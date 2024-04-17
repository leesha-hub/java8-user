package dev.lsh.java8user.member.dto;

import dev.lsh.java8user.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MemberCreateResponseDTO {
    private Integer memDetailNum;
    private String memId;
    private String memPw;
    private String nickname;
    private String phone;
    private String email;
    private LocalDateTime insertDateTime;

    public MemberCreateResponseDTO fromMemberCreateLog(Member member) {
        this.memDetailNum = member.getMemDetailNum();
        this.memId = member.getMemId();
        this.memPw = member.getMemPw();
        this.nickname = member.getNickname();
        this.phone = member.getPhone();
        this.email = member.getEmail();
        this.insertDateTime = member.getInsertDateTime();
        return this;
    }

    public static MemberCreateResponseDTO MemberCreateFactory(Member member) {
        MemberCreateResponseDTO memberCreateResponseDTO = new MemberCreateResponseDTO();
        memberCreateResponseDTO.fromMemberCreateLog(member);
        return memberCreateResponseDTO;
    }
}