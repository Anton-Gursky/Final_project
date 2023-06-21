package interpol.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Связь OneToOne на Country
//    @Column(name = "country_id")
//    private int country_id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    // Связь ManyToOne на User
//    @Column(name = "user_id")
//    private int user_id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //Связь OneToOne на OrderDetail
//    @Column(name = "order_detail_id")
//    private int order_detail_id;
    @OneToOne(optional = false, mappedBy = "order")
    public OrderDetail orderDetail;

    @OneToOne(optional = false, mappedBy = "order")
    public OrderResult orderResult;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<Info> infos;

    @Column(name = "date")
    private Date date;

    @Column(name = "reward")
    private String reward;

    @Column(name = "confirm")
    private boolean confirm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public OrderResult getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(OrderResult orderResult) {
        this.orderResult = orderResult;
    }

    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", country=" + country +
                ", user=" + user +
                ", orderDetail=" + orderDetail +
                ", orderResult=" + orderResult +
                ", infos=" + infos +
                ", date=" + date +
                ", reward='" + reward + '\'' +
                ", confirm=" + confirm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && confirm == order.confirm && Objects.equals(country, order.country)
                && Objects.equals(user, order.user) && Objects.equals(orderDetail, order.orderDetail)
                && Objects.equals(orderResult, order.orderResult) && Objects.equals(infos, order.infos)
                && Objects.equals(date, order.date) && Objects.equals(reward, order.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, user, orderDetail, orderResult, infos, date, reward, confirm);
    }
}