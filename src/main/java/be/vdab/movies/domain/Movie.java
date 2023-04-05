package be.vdab.movies.domain;

import be.vdab.movies.exceptions.MovieHeeftDezeCommentAlException;
import be.vdab.movies.exceptions.MovieHeeftDezeDirectorAlException;
import be.vdab.movies.exceptions.MovieHeeftDezeGenreAlException;
import be.vdab.movies.exceptions.MovieHeeftDezeRoleAlException;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private long id;

    private String name;
    private int year;
    private BigDecimal ranking;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "distributorId")
    private Distributor distributor;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    @OrderBy("name")
    private Set<Genre> genres;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    @OrderBy("persoon")
    private Set<Director> directors;

    @ElementCollection
    @CollectionTable(name = "roles",
            joinColumns = @JoinColumn(name = "movieId"))
    @OrderBy("name")
    private Set<Role> roles;

    @ElementCollection
    @CollectionTable(name = "comments",
            joinColumns = @JoinColumn(name = "movieId"))
    @OrderBy("moment")
    private Set<Comment> comments;

    public Movie(long id, String name, int year, BigDecimal ranking, Distributor distributor) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.ranking = ranking;
        this.distributor = distributor;
        this.genres = new LinkedHashSet<>();
        this.directors = new LinkedHashSet<>();
        this.roles = new LinkedHashSet<>();
        this.comments = new LinkedHashSet<>();
    }

    protected Movie() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getRanking() {
        return ranking;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public Set<Genre> getGenres() {
        return Collections.unmodifiableSet(genres);
    }

    public void addGenre(Genre genre) {
        if (!genres.add(genre)) {
            throw new MovieHeeftDezeGenreAlException();
        }
    }

    public Set<Director> getDirectors() {
        return Collections.unmodifiableSet(directors);
    }

    public void addDirector(Director director) {
        if (!directors.add(director)) {
            throw new MovieHeeftDezeDirectorAlException();
        }
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public void addRole(Role role) {
        throw new MovieHeeftDezeRoleAlException();
    }

    public Set<Comment> getComments() {
        return Collections.unmodifiableSet(comments);
    }

    public void addComment(Comment comment) {
        if (!comments.add(comment)) {
            throw new MovieHeeftDezeCommentAlException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return year == movie.year && name.equals(movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }
}
