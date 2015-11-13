package pigeo.fr.domain;

import javax.persistence.*;

@Entity
@Table(name="\"User\"")

public class User {

    private int _id;
    private String firstname;
    private String lastname;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
