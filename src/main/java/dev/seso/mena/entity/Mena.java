package dev.seso.mena.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mena")
public class Mena implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "st_number", nullable = false, unique = true)
    private Long stNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guardian_last_name")
    private Guardian guardian;

    @Column(name = "date_designation_guardian")
    private LocalDate dateGuardianDesignation;

    @Column(name = "date_cessation_guardian")
    private LocalDate dateGuardianCessation;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Column(name = "status", nullable = false)
    private String status;

    public String getStatus() {

        this.status = "Active";

        LocalDate dateCompare = LocalDate.now();

        if (dateCompare.getYear() - this.getDateOfBirth().getYear() > 18) {
            this.status = "Passive";
        }

        return this.status;
    }

    public void setStatus() {

        this.status = "Active";

        LocalDate dateCompare = LocalDate.now();

        if (dateCompare.getYear() - this.getDateOfBirth().getYear() > 18) {
            this.status = "Passive";
        }

    }

}
