package interpol.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_id")
    private int country_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "order_detail_id")
    private int order_detail_id;

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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", country_id=" + country_id +
                ", user_id=" + user_id +
                ", order_detail_id=" + order_detail_id +
                ", date=" + date +
                ", reward='" + reward + '\'' +
                ", confirm=" + confirm +
                '}';
    }
}