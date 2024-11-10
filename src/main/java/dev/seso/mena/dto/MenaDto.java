package dev.seso.mena.dto;

import dev.seso.mena.entity.Guardian;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenaDto {

    private Long id;
    private Long stNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationality;
    private Guardian guardian;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String status;
    private LocalDate dateGuardianDesignation;
    private LocalDate dateGuardianCessation;


    public void setStatus() {

        this.status = "Active";

        LocalDate dateCompare = LocalDate.now();

        if (dateCompare.getYear() - this.getDateOfBirth().getYear() > 18) {
            this.status = "Passive";
        }

    }

    public String getStatus() {

        this.status = "Active";

        LocalDate dateCompare = LocalDate.now();

        if (dateCompare.getYear() - this.getDateOfBirth().getYear() > 18) {
            this.status = "Passive";
        }

        return this.status;
    }
}
