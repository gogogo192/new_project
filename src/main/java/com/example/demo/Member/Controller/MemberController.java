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
    @GetMapping("/{no}")  // no로 변경
    public ResponseEntity<Member> getMemberByNo(@PathVariable Long no) {  // no로 변경
        Optional<Member> member = memberService.getMemberByNo(no);  // 서비스 메소드도 no로 변경
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
    @PutMapping("/{no}")  // no로 변경
    public ResponseEntity<Member> updateMember(@PathVariable Long no, @RequestBody Member member) {  // no로 변경
        Member updatedMember = memberService.updateMember(no, member);  // 서비스 메소드도 no로 변경
        return updatedMember != null ? ResponseEntity.ok(updatedMember)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 회원 삭제
    @DeleteMapping("/{no}")  // no로 변경
    public ResponseEntity<Void> deleteMember(@PathVariable Long no) {  // no로 변경
        memberService.deleteMember(no);  // 서비스 메소드도 no로 변경
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}