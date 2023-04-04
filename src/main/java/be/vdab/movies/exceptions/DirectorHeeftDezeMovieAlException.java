package be.vdab.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DirectorHeeftDezeMovieAlException extends RuntimeException {
    public DirectorHeeftDezeMovieAlException() {
        super("Director heeft deze movie al.");
    }
}
