package interpol.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "crime")
public class Crime {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column (name = "punishment")
    private String punishment;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "crimes")
    private Set<OrderDetail> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", punishment='" + punishment + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}