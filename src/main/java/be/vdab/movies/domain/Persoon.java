package be.vdab.movies.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Persoon {
    private String firstname;
    private String lastname;

    public Persoon(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    protected Persoon(){

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoon persoon)) return false;
        return firstname.equals(persoon.firstname) && lastname.equals(persoon.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}
