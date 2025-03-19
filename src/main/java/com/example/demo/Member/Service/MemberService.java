package com.example.demo.Member.Service;

import com.example.demo.Item.Member;
import com.example.demo.Member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 추가
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // 모든 회원 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 특정 회원 조회 (기존 id -> no로 변경)
    public Optional<Member> getMemberByNo(Long no) {
        return memberRepository.findById(no); // no 기준으로 조회
    }

    // 회원 삭제
    public void deleteMember(Long no) {
        memberRepository.deleteById(no); // no 기준으로 삭제
    }

    // 회원 수정 (기존 id -> no로 변경)
    public Member updateMember(Long no, Member member) {
        if (memberRepository.existsById(no)) { // no 기준으로 확인
            member.setNo(no); // no를 기반으로 회원을 수정
            return memberRepository.save(member);
        }
        return null;
    }
}
