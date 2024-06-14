package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.entity.Member;
import jpabook.jpashop.domain.enums.MemberType;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행(Autowired 사용을 위해 설정 필요)
@Transactional // 테스트 케이스에 이 어노테이션이 있으면 테스트 시작 전에 트랜잭션을 시작하고, 테스트가 끝나면 롤백한다.
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;


    @Test
//    @Rollback(value = false)
    @DisplayName("회원 가입")
    public void joinTest() {
        // given
        Member newMember = new Member();
        newMember.setUserName("testUser");

        // when
        memberService.join(newMember); // 회원 가입
        em.flush(); // 영속성 컨텍스트에 있는 쿼리를 DB에 반영


        // then
        assertEquals(newMember, memberService.findOne(newMember.getId()));
    }



    @Test
    @DisplayName("이름 중복 회원 예외")
    public void duplicationUserNameTest() {
        // given
        Member member1 = new Member();
        member1.setUserName("홍길동");
        Member member2 = new Member();
        member2.setUserName("홍길동");


        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }

}