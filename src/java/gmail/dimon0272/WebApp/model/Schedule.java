package gmail.dimon0272.WebApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<Flight>();

    //For Hibernate
    public Schedule() { }
}
