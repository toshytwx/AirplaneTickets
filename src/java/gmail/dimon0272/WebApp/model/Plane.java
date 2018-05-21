package gmail.dimon0272.WebApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "plane")
public class Plane {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "bort_number")
    private Short bortNumber;

    @Column (name = "capacity")
    private Short passengerCapacity;

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "owner_id")
    private Company companyOwner;

    @ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "flight_id")
    private List<Flight> flight = new ArrayList<Flight>();

    //For Hibernate
    public Plane() { }


}
