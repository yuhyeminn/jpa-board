package com.jpa.bbs.service;

import com.jpa.bbs.domain.Member;

public interface MemberService {
    Member getOneMember(String email);

    void registerMember(Member m);
}
