package dev.lsh.java8user.member.service;

import dev.lsh.java8user.member.dto.MemberCreateDTO;
import dev.lsh.java8user.member.dto.MemberCreateResponseDTO;
import dev.lsh.java8user.member.entity.Member;
import dev.lsh.java8user.member.entity.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public MemberCreateResponseDTO insert(MemberCreateDTO memberCreateDTO) {
        Member member = Member.builder()
                .memId(memberCreateDTO.getMemId())
                .memPw(memberCreateDTO.getMemPw())
                .nickname(memberCreateDTO.getNickname())
                .memName(memberCreateDTO.getMemName())
                .phone(memberCreateDTO.getPhone())
                .email(memberCreateDTO.getEmail())
                .build();

        this.memberRepository.save(member);
        return MemberCreateResponseDTO.MemberCreateFactory(member);
    }
}
