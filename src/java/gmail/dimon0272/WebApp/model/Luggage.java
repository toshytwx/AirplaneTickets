package gmail.dimon0272.WebApp.model;

import javax.persistence.*;

@Entity
@Table(name = "luggage")
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

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getHandLuggage() {
        return handLuggage;
    }

    public void setHandLuggage(Boolean handLuggage) {
        this.handLuggage = handLuggage;
    }
}
