//package jpabook.jpashop.repository;
//
//import jpabook.jpashop.domain.entity.Member;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
////@With(SpringRunner.class)
//@SpringBootTest
//class MemberRepositoryTest {
//
//    @Autowired  private MemberRepository memberRepository;
//
//    @Test
//    @Order(1)
//    void saveTest() {
//        Member member = new Member();
//        member.setUserName("joel");
//        memberRepository.save(member);
////        assertNotNull(memberId);
//    }
//
//    @Test
//    @Order(2)
//    void findTest() {
//        Member findMember = memberRepository.find(1L);
//        assertEquals("joel", findMember.getUserName());
//        System.out.println("username: " + findMember.getUserName());
//    }
//
//
//}