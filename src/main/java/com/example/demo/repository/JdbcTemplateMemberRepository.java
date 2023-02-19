//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import java.sql.SQLException;
//import java.util.*;
//
//public class JdbcTemplateMemberRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcTemplateMemberRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void save(Member member) throws SQLException {
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("member");
//
//        // jdbcTemplate에서는 key, value 형태인 map을 통해 데이터 insert
//        Map<String, Object> mp = new HashMap<>();
//        mp.put("name", member.getName());
//
//        jdbcInsert.execute(new MapSqlParameterSource(mp));
//
//    }
//
//    public List<Member> findAll() throws SQLException {
//        return null;
//    }
//
//    public Member findById(Long id) throws SQLException {
//        return null;
//    }
//
//    public List<Member> findByName(String name){
//        return null;
//    }
//
//}
