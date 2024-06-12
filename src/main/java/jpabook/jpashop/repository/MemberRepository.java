package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long memberId) {
        return em.find(Member.class, memberId);
    }

}
