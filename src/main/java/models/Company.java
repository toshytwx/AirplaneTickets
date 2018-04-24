package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "phone")
    private String phone;

    @Column (name = "address")
    private String address;

    @ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "airport_id")
    private List<Airport> airports = new ArrayList<Airport>();

    //For Hibernate
    public Company() { }
}
