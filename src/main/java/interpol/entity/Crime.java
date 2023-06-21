package interpol.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    // Переделанная связь ManyToMany между OrderDetail и Crime на 2 связи OneToMany между OrderDetail, Crime
    // и промежуточной таблицей CriminalCrimeMap
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "crime")
    private List<CriminalCrimeMap> criminalCrimeMaps;

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

    public List<CriminalCrimeMap> getCriminalCrimeMaps() {
        return criminalCrimeMaps;
    }

    public void setCriminalCrimeMaps(List<CriminalCrimeMap> criminalCrimeMaps) {
        this.criminalCrimeMaps = criminalCrimeMaps;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", punishment='" + punishment + '\'' +
                ", criminalCrimeMaps=" + criminalCrimeMaps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return id == crime.id && Objects.equals(name, crime.name) && Objects.equals(punishment, crime.punishment) &&
                Objects.equals(criminalCrimeMaps, crime.criminalCrimeMaps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, punishment, criminalCrimeMaps);
    }
}