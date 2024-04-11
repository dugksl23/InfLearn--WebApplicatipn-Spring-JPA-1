package JPA.Book.jpashop.orderItem.domain;

import JPA.Book.jpashop.item.domain.Item;
import JPA.Book.jpashop.order.domain.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue
    private long id;

    @Column(name="order_item_price")
    private long price;
    @Column(name="order_item_count")
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orders_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;


}