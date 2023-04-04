package be.vdab.movies.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class Comment {
    private String emailAdress;
    private String comment;
    private LocalDateTime moment;

    public Comment(@Email @NotNull String emailAdress, @NotNull String comment, @NotNull LocalDateTime moment) {
        this.emailAdress = emailAdress;
        this.comment = comment;
        this.moment = moment;
    }

    protected Comment() {

    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getMoment() {
        return moment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment1)) return false;
        return emailAdress.equals(comment1.emailAdress) && comment.equals(comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAdress, comment);
    }
}
