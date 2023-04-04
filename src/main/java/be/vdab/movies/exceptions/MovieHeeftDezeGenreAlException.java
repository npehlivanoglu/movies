package be.vdab.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MovieHeeftDezeGenreAlException extends RuntimeException {
    public MovieHeeftDezeGenreAlException() {
        super("Movie heeft deze genre al.");
    }
}
