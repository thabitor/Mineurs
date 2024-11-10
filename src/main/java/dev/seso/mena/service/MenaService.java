package dev.seso.mena.service;
import dev.seso.mena.dto.MenaDto;
import java.util.List;

public interface MenaService {
    MenaDto createMena(MenaDto menaDto);
    MenaDto getMenaById(Long menaId);
    List<MenaDto> getAllMena();
    MenaDto updateMena(Long menaId, MenaDto updatedMena);
    public void deleteMena(Long menaId);

}
