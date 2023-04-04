package be.vdab.movies.dto;

import be.vdab.movies.domain.Persoon;

public record FirstNameLastName(String firstName, String lastName) {
    public FirstNameLastName(Persoon persoon) {
        this(persoon.getFirstname(), persoon.getLastname());
    }
}
