package be.vdab.movies.services;

import be.vdab.movies.domain.Movie;
import be.vdab.movies.exceptions.MovieNietGevondenException;
import be.vdab.movies.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findByYear(int year) {
        return movieRepository.findAllByYearOrderByName(year);
    }

    public Optional<Movie> findById(long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findByIdMetAlles(long id) {
        return movieRepository.findByIdMetAlles(id);
    }

    @Transactional
    public int increaseRanking(long id) {
        if (movieRepository.increaseRanking(id) == 0) {
            throw new MovieNietGevondenException();
        } else {
            return 1;
        }
    }
}
