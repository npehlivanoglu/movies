package be.vdab.movies.repositories;

import be.vdab.movies.domain.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @EntityGraph(attributePaths = "distributor")
    List<Movie> findAllByYearOrderByName(int year);

    @EntityGraph(attributePaths = {"genres","directors","roles"})
    Optional<Movie> findById(long id);
}
