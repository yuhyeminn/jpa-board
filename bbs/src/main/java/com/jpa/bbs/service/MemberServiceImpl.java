package com.jpa.bbs.service;

import com.jpa.bbs.domain.Member;
import com.jpa.bbs.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member getOneMember(String email) {
        Member m;

        m = memberRepository.getByMemberEmail(email);
        if(m==null) m = new Member();

        return m;
    }

    @Override
    public void registerMember(Member m) {
        memberRepository.save(m);
    }
}
