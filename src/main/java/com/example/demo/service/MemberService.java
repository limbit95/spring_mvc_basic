package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.JdbcMemberRepository;
//import com.example.demo.repository.MemberRepository;
//import com.example.demo.repository.JdbcTemplateMemberRepository;
//import com.example.demo.repository.JdbcTemplateMemberRepository;
import com.example.demo.repository.JpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
// 만약 DB 연동이 있다면 @Transactional
@Transactional
public class MemberService {
//    private final MemberRepository memberRepository;
//    @Autowired
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    private final JpaMemberRepository memberRepository;
    @Autowired
    public MemberService(JpaMemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void create(Member member) throws SQLException {
        memberRepository.save(member);
    }

    public List<Member> findAll() throws SQLException {
        return memberRepository.findAll();
    }

    public Member findById(Long id) throws SQLException {
        return memberRepository.findById(id);//.orElse(null);    // Jpa 기술 적용 했을 때 적용 가능
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

//    public List<Member> findByIdAndName(Long id, String name){
//        return memberRepository.findByIdAndName(id, name);
//    }


}