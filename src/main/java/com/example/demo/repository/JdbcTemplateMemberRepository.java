//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;
//
//@Repository
//public class JdbcTemplateMemberRepository {
//    private final DataSource datasource;
//
//    @Autowired
//    public JdbcTemplateMemberRepository(DataSource datasource) {
//        this.datasource = datasource;
//    }
//
//    public void save(Member member) throws SQLException {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
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
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
//        List<Member> lst = jdbcTemplate.query("select * from member", memberRowMapper());
//
//        return lst;
//    }
//
//    public Member findById(Long id) throws SQLException {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
//        List<Member> lst = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
//
//        return lst.stream().findAny().orElseGet(null);
//    }
//
//    public List<Member> findByName(String name){
//        return null;
//    }
//
//    private RowMapper<Member> memberRowMapper(){
//        return new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Member member = new Member();
//                member.setId(rs.getLong("id"));
//                member.setName(rs.getString("name"));
//                return member;
//            }
//        };
//    }
//
//}
