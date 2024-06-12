package jpabook.jpashop.domain.entity.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.entity.Category;
import jpabook.jpashop.domain.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

//    @OneToMany(mappedBy = "item")
//    private List<OrderItem> orderItems;

    private int price;

    private int quantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


}
