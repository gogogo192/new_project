package com.example.demo.Member.Repository;
import com.example.demo.Item.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}