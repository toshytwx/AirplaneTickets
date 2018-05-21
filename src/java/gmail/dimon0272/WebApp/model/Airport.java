package gmail.dimon0272.WebApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "airport")
public class Airport {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "address")
    private String address;

    @Column (name = "phone")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Terminal> terminals = new ArrayList<Terminal>();

    @Column (name = "lat")
    private Double lat;

    @Column (name = "lng")
    private Double lng;

    //For Hibernate
    public Airport() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
