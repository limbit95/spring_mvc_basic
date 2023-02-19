package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcMemberRepository {

    // Datasource 필요 (JDBC와 DB를 연동하는 드라이버)
    private final DataSource dataSource;

    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Member member) throws SQLException {
        String sql = "insert into member(name) values(?)";

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, member.getName());
        // excuteQuery는 조회시, insert 혹 update는 excuteUpdate를 사용
        preparedStatement.executeUpdate();
    }

    public List<Member> findAll() throws SQLException {
        String sql = "select * from member";
//      Connection Connection connection = null;
//      PreparedStatement preparedStatement = null;
//        ResultSet resultset = null;

        // 드라이버를 통해 DB정보를 가져와서 connection을 맺음
        Connection connection = dataSource.getConnection();
        // key를 꺼내서 preparedStatement에 담는 것
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // jdbc를 통해서 쿼리를 수행하면 그 결과 객체는 ResultSet 객체임
        ResultSet resultset = preparedStatement.executeQuery();
        List<Member> lst = new ArrayList<>();
        while(resultset.next()){
            Member member = new Member();
            member.setId(resultset.getLong("id"));
            member.setName(resultset.getString("name"));
            lst.add(member);
        }

        return lst;
    }

    public Member findById(Long id) throws SQLException {
        String sql = "select * from member where id = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultset = preparedStatement.executeQuery();

        if(resultset.next()){
            Member member = new Member();
            member.setId(resultset.getLong("id"));
            member.setName(resultset.getString("name"));
            return member;
        }

        return null;
    }

    public List<Member> findByName(String name){
        return null;
    }


}