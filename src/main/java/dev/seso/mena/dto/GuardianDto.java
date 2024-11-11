package dev.seso.mena.dto;
import dev.seso.mena.entity.Mena;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GuardianDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Mena> minors;
}
