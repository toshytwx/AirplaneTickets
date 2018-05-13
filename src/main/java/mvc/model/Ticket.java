package mvc.model;

import utils.TicketType;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
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
}
