package dev.seso.mena.service;
import dev.seso.mena.dto.GuardianDto;
import java.util.List;

public interface GuardianService {

    GuardianDto createGuardian(GuardianDto guardianDto);
    GuardianDto getGuardianById(Long guardianId);
    List<GuardianDto> getAllGuardian();
    GuardianDto updateGuardian(Long guardianId, GuardianDto updatedGuardian);
    public void deleteGuardian(Long guardianId);
    
}
