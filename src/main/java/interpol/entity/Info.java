package interpol.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "info")
public class Info {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Связь ManyToOne на Order
//    @Column(name = "order_id")
//    private int order_id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "info")
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", order=" + order +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info1 = (Info) o;
        return id == info1.id && Objects.equals(order, info1.order) && Objects.equals(info, info1.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, info);
    }
}