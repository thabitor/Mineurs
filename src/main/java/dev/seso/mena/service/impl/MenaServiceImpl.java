package dev.seso.mena.service.impl;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.dto.MenaDto;
import dev.seso.mena.entity.Guardian;
import dev.seso.mena.entity.Mena;
import dev.seso.mena.exception.ResourceNotFoundException;
import dev.seso.mena.mapper.GuardianMapper;
import dev.seso.mena.mapper.MenaMapper;
import dev.seso.mena.repository.GuardianRepository;
import dev.seso.mena.repository.MenaRepository;
import dev.seso.mena.service.MenaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenaServiceImpl implements MenaService {

    private MenaRepository menaRepository;
    private GuardianRepository guardianRepository;

    @Override
    public MenaDto createMena(MenaDto menaDto) {
        Mena mena = MenaMapper.mapToMena(menaDto);
        Guardian guardian = mena.getGuardian();
        if (guardian != null) {
            guardianRepository.save(guardian);
        }
        Mena savedMena = menaRepository.save(mena);
        return MenaMapper.mapToMenaDto(savedMena);
    }


    @Override
    public MenaDto getMenaById(Long menaId) {
        Mena mena = menaRepository.findById(menaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Mena record with Id " + menaId + " could not be found"));
        return MenaMapper.mapToMenaDto(mena);
    }

    @Override
    public List<MenaDto> getAllMena() {
        List<Mena> allMena = menaRepository.findAll();
        return allMena.stream().map(MenaMapper::mapToMenaDto)
                .collect(Collectors.toList());
    }


    @Override
    public MenaDto updateMena(Long menaId, MenaDto updatedMena) {
       Mena mena = menaRepository.findById(menaId).orElseThrow(
                () -> new ResourceNotFoundException("Mena record with Id " + menaId + " could not be found")
        );

        if (updatedMena.getFirstName() != null)
            mena.setFirstName(updatedMena.getFirstName());
        if (updatedMena.getLastName() != null)
            mena.setLastName(updatedMena.getLastName());
        if (updatedMena.getStNumber() != null)
            mena.setStNumber(updatedMena.getStNumber());
        if (updatedMena.getNationality() != null)
            mena.setNationality(updatedMena.getNationality());
        if (updatedMena.getDateOfBirth() != null)
            mena.setDateOfBirth(updatedMena.getDateOfBirth());
        if (updatedMena.getGuardian()!= null)
            mena.setGuardian(updatedMena.getGuardian());
        if (updatedMena.getDateGuardianDesignation() != null)
            mena.setDateGuardianDesignation(updatedMena.getDateGuardianDesignation());
        if (updatedMena.getDateGuardianCessation() != null)
            mena.setDateGuardianCessation(updatedMena.getDateGuardianCessation());
        mena.setStatus();

        Mena updatedMenaObj = menaRepository.save(mena);

        return MenaMapper.mapToMenaDto(updatedMenaObj);
    }

    @Override
    public void deleteMena(Long menaId) {
        Mena mena = menaRepository.findById(menaId).orElseThrow(
                () -> new ResourceNotFoundException("Mena record with Id " + menaId + " could not be found")
        );

        menaRepository.deleteById(menaId);
    }


}
