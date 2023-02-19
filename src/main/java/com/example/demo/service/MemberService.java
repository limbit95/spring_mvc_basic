package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.JdbcMemberRepository;
//import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    private final JdbcMemberRepository memberRepository;
    @Autowired
    public MemberService(JdbcMemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void create(Member member){
        memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(Long id){
        return memberRepository.findById(id);//.orElse(null);    // Jpa 기술 적용 했을 때 적용 가능
    }

    public List<Member> findByName(String name){
        return memberRepository.findByName(name);
    }

//    public List<Member> findByIdAndName(Long id, String name){
//        return memberRepository.findByIdAndName(id, name);
//    }


}