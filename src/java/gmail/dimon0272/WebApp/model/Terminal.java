package gmail.dimon0272.WebApp.model;

import javax.persistence.*;

@Entity
@Table (name = "terminal")
public class Terminal {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "signature")
    private String signature;

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "airport_id")
    private Airport airport;

    //For Hibernate
    public Terminal() {}
}
