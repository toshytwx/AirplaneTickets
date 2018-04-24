package models;

import javax.persistence.*;

@Entity
@Table(name = "luggages")
public class Luggage {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer owner;

    @Column (name = "weight")
    private Double weight;

    @Column (name = "carryon")
    private Boolean handLuggage;

    //For Hibernate
    public Luggage() { }
}
