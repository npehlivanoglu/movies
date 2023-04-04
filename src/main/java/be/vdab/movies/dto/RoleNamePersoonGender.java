package be.vdab.movies.dto;

import be.vdab.movies.domain.Gender;
import be.vdab.movies.domain.Role;

public record RoleNamePersoonGender(String roleName, String firstName, String lastName, Gender gender) {
    public RoleNamePersoonGender(Role role) {
        this(role.getName(),
                role.getActor().getPersoon().getFirstname(),
                role.getActor().getPersoon().getLastname(),
                role.getActor().getGender());
    }
}
