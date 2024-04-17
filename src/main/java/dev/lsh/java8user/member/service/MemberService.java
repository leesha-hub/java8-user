package dev.lsh.java8user.member.service;

import dev.lsh.java8user.member.dto.MemberCreateDTO;
import dev.lsh.java8user.member.dto.MemberCreateResponseDTO;
import dev.lsh.java8user.member.dto.MemberListResponseDTO;
import dev.lsh.java8user.member.entity.Member;
import dev.lsh.java8user.member.entity.MemberRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public MemberCreateResponseDTO insert(MemberCreateDTO memberCreateDTO) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        Member member = Member.builder()
                .memId(memberCreateDTO.getMemId())
                .memPw(memberCreateDTO.getMemPw())
                .nickname(memberCreateDTO.getNickname())
                .memName(memberCreateDTO.getMemName())
                .phone(memberCreateDTO.getPhone())
                .email(memberCreateDTO.getEmail())
                .insertDateTime(currentDateTime)
                .build();

        this.memberRepository.save(member);
        return MemberCreateResponseDTO.MemberCreateFactory(member);
    }

    public Page<MemberListResponseDTO> memberList(Integer page, Integer pageSize, Integer pageSort){
        Page<Member> memberPage = null;
        int rePageSize = 3;
        int rePage = 1;
        String rePageSort = "insertDateTime";

        if (page != null) {
            rePage = page;
        }

        if (page == null || page < 1) {
            rePage = 0;
        } else {
            rePage -= 1;
        }

        if(pageSize != null) {
            rePageSize = pageSize;
        }

        if(pageSort == 1) {
            rePageSort = "memName";; // 0 : 가입일순, 1: 이름순
        }

        Pageable pageable = PageRequest.of(rePage, rePageSize, Sort.Direction.DESC, rePageSort);
        memberPage = this.memberRepository.findMemberByPaging(pageable);

        if(memberPage.isEmpty()) {
            return Page.empty(pageable);
        } else {
            List<MemberListResponseDTO> memberList = memberPage.getContent().stream()
                    .map(member -> new MemberListResponseDTO(member.getMemId(), member.getNickname(), member.getMemName(), member.getPhone(), member.getEmail(), member.getInsertDateTime())
                    ).collect(Collectors.toList());

            return new PageImpl<>(memberList, pageable, memberPage.getTotalElements());
        }
    }
}