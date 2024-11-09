package dev.seso.mena.dto;

import dev.seso.mena.entity.Tutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenaDto {

    private Long id;
    private Long stNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String nationality;
    private Tutor tutor;
    private String status;

}
