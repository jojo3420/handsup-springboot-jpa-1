package jpabook.jpashop.domain.entity;

import jakarta.persistence.*;
import jpabook.jpashop.domain.enums.MemberType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_name", length = 30)
    private String userName;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();
}
