package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.repositories.MemberRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MemberService {
    private MemberRepository memberRepository;

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
    public void MemberCreate(Member member) {
        memberRepository.save(member);
    }
}
