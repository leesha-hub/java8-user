package dev.lsh.java8user.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    /*
      회원id : memId
      비밀번호 : memPw
      닉네임 : nickname
      이름 : memName
      전화번호 : phone
      이메일주소 : email
      가입일 : insertDateTime
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memDetailNum;

    @NotNull
    @Column(length = 80, unique = true)
    private String memId;

    @NotNull
    @Column(length = 60)
    private String memPw;

    @Column(length = 30)
    private String nickname;

    @NotNull
    @Column(length = 30)
    private String memName;

    @NotNull
    @Column(length = 20, unique = true)
    private String phone;

    @Column(length = 50)
    private String email;

    @NotNull
    @CreationTimestamp
    private LocalDateTime insertDateTime;
}