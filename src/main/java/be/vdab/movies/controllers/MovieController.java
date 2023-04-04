package be.vdab.movies.controllers;

import be.vdab.movies.domain.Director;
import be.vdab.movies.domain.Genre;
import be.vdab.movies.domain.Movie;
import be.vdab.movies.dto.FirstNameLastName;
import be.vdab.movies.dto.RoleNamePersoonGender;
import be.vdab.movies.exceptions.MovieNietGevondenException;
import be.vdab.movies.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("movies")
class MovieController {
    private final MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    private record NameRankingDistributorName(String name, BigDecimal ranking, String distributorName) {
        NameRankingDistributorName(Movie movie) {
            this(movie.getName(), movie.getRanking(), movie.getDistributor().getName());
        }
    }

    private record MovieMetAlles(String name, int year, BigDecimal ranking, List<String> genreNames,
                                 List<FirstNameLastName> directorNames,
                                 List<RoleNamePersoonGender> roleDetails) {

        MovieMetAlles(Movie movie) {
            this(movie.getName(), movie.getYear(), movie.getRanking(),
                    movie.getGenres().stream().map(Genre::getName).toList(),
                    movie.getDirectors().stream().map(Director::getPersoon).map(FirstNameLastName::new).toList(),
                    movie.getRoles().stream().map(RoleNamePersoonGender::new).toList());
        }


    }

    @GetMapping(params = "year")
    Stream<NameRankingDistributorName> findAllByYear(int year) {
        return movieService.findByYear(year)
                .stream()
                .map(NameRankingDistributorName::new);
    }

    @GetMapping("/{id}")
    MovieMetAlles findById(@PathVariable long id) {
        var movie = movieService.findById(id).orElseThrow(MovieNietGevondenException::new);
        return new MovieMetAlles(movie);
    }
}
