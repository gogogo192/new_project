package com.example.demo.Member.Controller;

import com.example.demo.Item.Member;
import com.example.demo.Member.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 모든 회원 조회
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // 특정 회원 조회
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberService.getMemberById(id);
        return member.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 회원 추가
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member newMember = memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMember);
    }

    // 회원 수정
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return updatedMember != null ? ResponseEntity.ok(updatedMember)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}