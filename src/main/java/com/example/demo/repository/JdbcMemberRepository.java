package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
public class JdbcMemberRepository {

    // Datasource 필요 (JDBC와 DB를 연동하는 드라이버)
    private final DataSource dataSource;

    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Member member){

    }

    public List<Member> findAll(){
        String sql = "select * from member";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Resultset resultset = null;

        connection =
    }

    public Member findById(Long id){
        return null;
    }

    public List<Member> findByName(String name){
        return null;
    }


}