package be.vdab.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ActorHeeftDezeRoleAlException extends RuntimeException {
    public ActorHeeftDezeRoleAlException() {
        super("Actor heeft deze rol al.");
    }
}
