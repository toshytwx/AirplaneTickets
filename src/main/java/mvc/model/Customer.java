package mvc.model;

import javax.persistence.*;

@Entity
@Table (name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "surname")
    private String surname;

    @Column (name = "passport_code")
    private String passportCode;

    @Column (name = "telephone")
    private String phoneNumber;

    @Column (name = "birthDay")
    private String birthDay;

    //For Hibernate
    public Customer() { }
}
