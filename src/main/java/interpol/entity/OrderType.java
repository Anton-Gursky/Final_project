package interpol.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_type")
public class OrderType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

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

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}