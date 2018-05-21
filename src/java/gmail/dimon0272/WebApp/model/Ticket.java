package gmail.dimon0272.WebApp.model;

import gmail.dimon0272.WebApp.utils.TicketType;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "price")
    private String price;

    @Column (name = "type")
    private TicketType type;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Flight flight;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Luggage luggage;

    //For Hibernate
    public Ticket() { }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        Double priceD = 0.0;
        priceD = Math.pow(100.0, type.ordinal());
        this.price = String.valueOf(priceD);
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }
}
