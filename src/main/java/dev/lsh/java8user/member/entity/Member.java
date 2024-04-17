package dev.lsh.java8user.member.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Member {

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
    private String memName;

    @NotNull
    @Column(length = 20, unique = true)
    private String phone;

    @Column(length = 50)
    private String email;
}