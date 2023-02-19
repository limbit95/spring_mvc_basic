//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//// Jdbc
//// JdbcTemplate
//// Jpa 기술
//// 기술명 : SpringDataJpa
//@Repository
//public interface MemberRepository extends JpaRepository<Member, Long> {
//
//    List<Member> findByName(String name);
//    Member findByIdAndName(Long id, String name);
//
//}