package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }


    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }


    public List<Member> findByName(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("userName must not be empty");
        }
        return em.createQuery("SELECT m FROM Member m WHERE m.userName = :userName", Member.class)
                .setParameter("userName", userName)
                .getResultList();
        
    }






}
