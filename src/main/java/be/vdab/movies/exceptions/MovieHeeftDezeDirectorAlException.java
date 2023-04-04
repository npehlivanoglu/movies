package be.vdab.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MovieHeeftDezeDirectorAlException extends RuntimeException {
    public MovieHeeftDezeDirectorAlException() {
        super("Movie heeft deze director al.");
    }
}
