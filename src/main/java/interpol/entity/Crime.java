package interpol.entity;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", punishment='" + punishment + '\'' +
                '}';
    }
}