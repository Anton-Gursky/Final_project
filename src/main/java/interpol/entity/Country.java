package interpol.entity;

import javax.persistence.*;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && Objects.equals(name, country.name) && Objects.equals(policeDepartment, country.policeDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, policeDepartment);
    }
}