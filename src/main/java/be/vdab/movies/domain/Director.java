package be.vdab.movies.domain;

import be.vdab.movies.exceptions.DirectorHeeftDezeMovieAlException;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    private long id;
    @Embedded
    private Persoon persoon;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "moviesdirectors",
            joinColumns = @JoinColumn(name = "directorId"),
            inverseJoinColumns = @JoinColumn(name = "movieId"))
    private Set<Movie> movies;

    public Director(long id, Persoon persoon) {
        this.id = id;
        this.persoon = persoon;
        this.movies = new LinkedHashSet<>();
    }

    protected Director() {
    }


    public long getId() {
        return id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public Set<Movie> getMovies() {
        return Collections.unmodifiableSet(movies);
    }

    public void addMovie(Movie movie) {
        if (!movies.add(movie)) {
            throw new DirectorHeeftDezeMovieAlException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director director)) return false;
        return persoon.equals(director.persoon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persoon);
    }
}
