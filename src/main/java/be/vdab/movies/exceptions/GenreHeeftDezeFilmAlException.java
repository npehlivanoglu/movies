package be.vdab.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class GenreHeeftDezeFilmAlException extends RuntimeException {
    public GenreHeeftDezeFilmAlException() {
        super("Genre heeft deze film al.");
    }
}
