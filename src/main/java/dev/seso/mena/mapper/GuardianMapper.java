package dev.seso.mena.mapper;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.entity.Guardian;

public class GuardianMapper {

    public static GuardianDto mapToGuardianDto (Guardian guardian) {
        return new GuardianDto(
                guardian.getId(),
                guardian.getFirstName(),
                guardian.getLastName(),
                guardian.getMinors()

        );
    }

    public static Guardian mapToGuardian(GuardianDto guardianDto) {
        return new Guardian (
                guardianDto.getId(),
                guardianDto.getFirstName(),
                guardianDto.getLastName(),
                guardianDto.getMinors()
        );
    }
}
