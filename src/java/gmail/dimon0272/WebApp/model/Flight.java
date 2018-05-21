package gmail.dimon0272.WebApp.model;


import gmail.dimon0272.WebApp.utils.FlightStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "flight")
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<Airport> getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(List<Airport> departureAirport) {
        this.departureAirport = departureAirport;
    }

    public List<Airport> getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(List<Airport> arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}
