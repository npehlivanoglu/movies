package be.vdab.movies.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Role {
    private String name;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "actorId")
    private Actor actor;

    public Role(String name, Actor actor) {
        this.name = name;
        this.actor = actor;
    }
    protected Role(){

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(name, role.name);
    }

    public Actor getActor() {
        return actor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
