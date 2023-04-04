package be.vdab.movies.domain;

import be.vdab.movies.exceptions.ActorHeeftDezeRoleAlException;
import be.vdab.movies.exceptions.MovieHeeftDezeRoleAlException;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    private long id;
    @Embedded
    private Persoon persoon;
    @Enumerated(EnumType.STRING)
    private Gender gender;


    public Actor(long id, Persoon persoon, Gender gender) {
        this.id = id;
        this.persoon = persoon;
        this.gender = gender;
    }

    protected Actor() {
    }

    public long getId() {
        return id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor actor)) return false;
        return persoon.equals(actor.persoon);
    }


    public void addRole(Role role) {
        throw new ActorHeeftDezeRoleAlException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(persoon);
    }
}
