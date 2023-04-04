package be.vdab.movies.domain;

import be.vdab.movies.exceptions.GenreHeeftDezeFilmAlException;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "moviesgenres",
            joinColumns = @JoinColumn(name = "genreId"),
            inverseJoinColumns = @JoinColumn(name = "movieId"))
    private Set<Movie> movies;

    public Genre(long id, String name) {
        this.name = name;
        this.id = id;
        movies = new LinkedHashSet<>();
    }

    protected Genre() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Movie> getMovies() {
        return Collections.unmodifiableSet(movies);
    }

    public void addFilm(Movie movie) {
        if (!movies.add(movie)) {
            throw new GenreHeeftDezeFilmAlException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre genre)) return false;
        return name.equals(genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
