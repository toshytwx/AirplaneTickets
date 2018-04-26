package mvc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "airports")
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

    //For Hibernate
    public Airport() { }
}
