package be.vdab.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MovieHeeftDezeCommentAlException extends RuntimeException {
    public MovieHeeftDezeCommentAlException() {
        super("Movie heeft deze comment al.");
    }
}
