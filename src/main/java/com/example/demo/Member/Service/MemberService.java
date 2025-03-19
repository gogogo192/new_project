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

        // 특정 회원 조회
        public Optional<Member> getMemberById(Long id) {
            return memberRepository.findById(id);
        }

        // 회원 삭제
        public void deleteMember(Long id) {
            memberRepository.deleteById(id);
        }

        // 회원 수정
        public Member updateMember(Long id, Member member) {
            if (memberRepository.existsById(id)) {
                member.setNo(id);
                return memberRepository.save(member);
            }
            return null;
        }
    }