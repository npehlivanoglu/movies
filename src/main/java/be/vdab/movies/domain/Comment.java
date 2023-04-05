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
    private String emailAddress;
    private String comment;
    private LocalDateTime moment;

    public Comment(@Email @NotNull String emailAddress, @NotNull String comment, @NotNull LocalDateTime moment) {
        this.emailAddress = emailAddress;
        this.comment = comment;
        this.moment = moment;
    }

    protected Comment() {

    }

    public String getEmailAddress() {
        return emailAddress;
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
        return emailAddress.equals(comment1.emailAddress) && comment.equals(comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, comment);
    }


}
