package dev.seso.mena.service;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.dto.MenaDto;
import dev.seso.mena.entity.Mena;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MenaService {
    MenaDto createMena(MenaDto menaDto);
    MenaDto getMenaById(Long menaId);
    List<MenaDto> getAllMena();
    MenaDto updateMena(Long menaId, MenaDto updatedMena);
    public void deleteMena(Long menaId);
//    MenaDto assignGuardianToMena(Long menaId, Long guardianId);

}
