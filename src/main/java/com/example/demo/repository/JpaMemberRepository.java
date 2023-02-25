package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaMemberRepository {

    // Datasource가 아닌 Jpa에서는 EntityManager라는 드라이버를 사용
    private final EntityManager em;

    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Member member) {
        // persist는 return 타입이 없는 insert
        // merge는 return 타입이 없는 update
        em.persist(member);
    }

    public List<Member> findAll() {
        // 여기서 사용되는 쿼리문은 jpql이라 부름. jpa의 sql문법
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        return members;
    }

    public Member findById(Long id) {
        Member member = em.find(Member.class, id);

        return member;
    }

    public List<Member> findByName(String name) {
        List<Member> members = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return members;
    }


}
