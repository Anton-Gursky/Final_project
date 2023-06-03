package interpol.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_type")
public class OrderType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderType")
    private Set<OrderDetail> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}