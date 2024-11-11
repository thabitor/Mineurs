package dev.seso.mena.service.impl;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.entity.Guardian;
import dev.seso.mena.exception.ResourceNotFoundException;
import dev.seso.mena.mapper.GuardianMapper;
import dev.seso.mena.repository.GuardianRepository;
import dev.seso.mena.service.GuardianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuardianServiceImpl implements GuardianService {

    private GuardianRepository guardianRepository;

    @Override
    public GuardianDto createGuardian(GuardianDto guardianDto) {
        Guardian guardian = GuardianMapper.mapToGuardian(guardianDto);
        Guardian savedGuardian = guardianRepository.save(guardian);
        return GuardianMapper.mapToGuardianDto(savedGuardian);
    }



    @Override
    public GuardianDto getGuardianById(Long guardianId) {
        Guardian guardian = guardianRepository.findById(guardianId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Guardian record with Id " + guardianId + " could not be found"));
        return GuardianMapper.mapToGuardianDto(guardian);
    }

    @Override
    public List<GuardianDto> getAllGuardian() {
        List<Guardian> allGuardian = guardianRepository.findAll();
        return allGuardian.stream().map(GuardianMapper::mapToGuardianDto)
                .collect(Collectors.toList());
    }


    @Override
    public GuardianDto updateGuardian(Long guardianId, GuardianDto updatedGuardian) {
        Guardian guardian = guardianRepository.findById(guardianId).orElseThrow(
                () -> new ResourceNotFoundException("Guardian record with Id " + guardianId + " could not be found")
        );

        guardian.setFirstName(updatedGuardian.getFirstName());
        guardian.setLastName(updatedGuardian.getLastName());
        guardian.setMinors(updatedGuardian.getMinors());

        Guardian updatedGuardianObj = guardianRepository.save(guardian);

        return GuardianMapper.mapToGuardianDto(updatedGuardianObj);
    }

    @Override
    public void deleteGuardian(Long guardianId) {
        Guardian guardian = guardianRepository.findById(guardianId).orElseThrow(
                () -> new ResourceNotFoundException("Guardian record with Id " + guardianId + " could not be found")
        );

        guardianRepository.deleteById(guardianId);
    }

}
