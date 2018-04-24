package models;

import utils.FlightStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "flights")
public class Flight {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "signature")
    private String signature;

    @ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "from_airport_id")
    private List<Airport> departureAirport = new ArrayList<Airport>();

    @ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "to_airport_id")
    private List<Airport> arrivalAirport = new ArrayList<Airport>();

    @OneToOne
    @PrimaryKeyJoinColumn
    private Schedule schedule;

    @Column (name = "departure_date")
    private Date departureDate;

    @Column (name = "status")
    private FlightStatus status;

    //For Hibernate
    public Flight() { }
}
