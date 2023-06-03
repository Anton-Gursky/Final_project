package interpol.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "police_department")
    private String police_department;

    @OneToOne(optional = false, mappedBy = "country")
    public Order order;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolice_department() {
        return police_department;
    }

    public void setPolice_department(String police_department) {
        this.police_department = police_department;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", police_department='" + police_department + '\'' +
                ", order=" + order +
                '}';
    }
}