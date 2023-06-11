package interpol.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "criminal_crime_map")
public class CriminalCrimeMap {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Связь ManyToOne на OrderDetail
//    @Column (name = "criminal_id")
//    private int criminalId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "criminal_id", nullable = false)
    private OrderDetail orderDetail;

    // Связь ManyToOne на Crime
//    @Column(name = "crime_id")
//    private int crimeId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "crime_id", nullable = false)
    private Crime crime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    @Override
    public String toString() {
        return "CriminalCrimeMap{" +
                "id=" + id +
                ", orderDetail=" + orderDetail +
                ", crime=" + crime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriminalCrimeMap that = (CriminalCrimeMap) o;
        return id == that.id && Objects.equals(orderDetail, that.orderDetail) && Objects.equals(crime, that.crime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDetail, crime);
    }
}