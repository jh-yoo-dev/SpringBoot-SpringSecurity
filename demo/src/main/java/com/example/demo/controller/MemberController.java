package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.repositories.MemberRepository;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model) {
        List<Member> members = memberService.getMembers();
        model.put("members", members);
        model.put("currentMemberId", user.getUsername());
        return "main";
    }

    @GetMapping("/admin")
    public String adminPage(Map<String, Object> model) {
        return "admin";
    }

    @GetMapping("/member/new")
    public String createMemberPage(Member member){
        return "createMember";
    }

    @PostMapping("/member/new")
    public String createMember(Member member){
        memberService.MemberCreate(member);
        return "redirect:/login";
    }


}
