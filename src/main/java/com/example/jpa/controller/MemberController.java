package com.example.jpa.controller;

import com.example.jpa.domain.Adress;
import com.example.jpa.domain.Member;
import com.example.jpa.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String  createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form ,BindingResult result){

        if(result.hasErrors()){
            return "members/createMemberForm";
        }
        Adress adress = new Adress(form.getCity(),form.getStreet(),form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(adress);

        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
