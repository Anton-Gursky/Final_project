package interpol.entity;

import javax.persistence.*;

@Entity
@Table(name = "criminal_crime_map")
public class CriminalCrimeMap {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "criminal_id")
    private int criminal_id;

    @Column(name = "crime_id")
    private int crime_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCriminal_id() {
        return criminal_id;
    }

    public void setCriminal_id(int criminal_id) {
        this.criminal_id = criminal_id;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    @Override
    public String toString() {
        return "CriminalCrimeMap{" +
                "id=" + id +
                ", criminal_id=" + criminal_id +
                ", crime_id=" + crime_id +
                '}';
    }
}