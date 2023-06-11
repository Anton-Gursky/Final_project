package interpol.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "police_department")
    private String policeDepartment;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

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

    public String getPolice_department() {
        return policeDepartment;
    }

    public void setPolice_department(String police_department) {
        this.policeDepartment = police_department;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", police_department='" + policeDepartment + '\'' +
                ", order=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && name.equals(country.name) && policeDepartment.equals(country.policeDepartment) && orders.equals(country.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, policeDepartment, orders);
    }
}