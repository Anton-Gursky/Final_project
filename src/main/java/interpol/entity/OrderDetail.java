package interpol.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "age")
    private String age;

    @Column(name = "date")
    private Date date;

    // Связь ManyToOne на OrderType
    //    @Column(name = "order_detail_type")
    //    private int order_detail_type;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_detail_type", nullable = false)
    private OrderType orderType;

    @OneToOne(optional = false, mappedBy = "orderDetail")
    public Order order;

    // Переделанная связь ManyToMany между OrderDetail и Crime на 2 связи OneToMany между OrderDetail, Crime
    // и промежуточной таблицей CriminalCrimeMap
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderDetail")
    private Set<Crime> crimes;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Set<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(Set<Crime> crimes) {
        this.crimes = crimes;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age='" + age + '\'' +
                ", date=" + date +
                ", orderType=" + orderType +
                ", order=" + order +
                ", crimes=" + crimes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id == that.id && gender == that.gender && Objects.equals(surname, that.surname)
                && Objects.equals(name, that.name) && Objects.equals(age, that.age)
                && Objects.equals(date, that.date) && Objects.equals(orderType, that.orderType)
                && Objects.equals(order, that.order) && Objects.equals(crimes, that.crimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, gender, age, date, orderType, order, crimes);
    }
}