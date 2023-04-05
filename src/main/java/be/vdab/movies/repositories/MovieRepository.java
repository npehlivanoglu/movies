package be.vdab.movies.repositories;

import be.vdab.movies.domain.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @EntityGraph(attributePaths = "distributor")
    List<Movie> findAllByYearOrderByName(int year);

    //@EntityGraph(attributePaths = {"genres", "directors"})
    Optional<Movie> findById(long id);


    @EntityGraph(attributePaths = {"genres", "directors","distributor"})
    @Query("select m from Movie m where m.id = :id")
    Optional<Movie> findByIdMetAlles(long id);

    @Modifying
    @Query("update Movie m set m.ranking = m.ranking + 1 where m.id = :id")
    int increaseRanking(long id);
}
