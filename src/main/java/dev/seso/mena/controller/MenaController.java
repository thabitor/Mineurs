package dev.seso.mena.controller;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.dto.MenaDto;
import dev.seso.mena.entity.Guardian;
import dev.seso.mena.entity.Mena;
import dev.seso.mena.mapper.GuardianMapper;
import dev.seso.mena.service.GuardianService;
import dev.seso.mena.service.MenaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/mena")
public class MenaController {

    private MenaService menaService;
    private GuardianService guardianService;

    //Build Add New Mena Record API

    @PostMapping
    public ResponseEntity<MenaDto> createMena(@RequestBody MenaDto menaDto) {
        MenaDto savedMena = menaService.createMena(menaDto);
            GuardianDto guardianDto = guardianService.getGuardianById(menaDto.getGuardian().getId());
            if (guardianDto != null) {
               Guardian existingGuardian = GuardianMapper.mapToGuardian(guardianDto);
                savedMena.setGuardian(existingGuardian);
            }
        return new ResponseEntity<>(savedMena, HttpStatus.CREATED);
    }

    //Build Get Mena Record API

    @GetMapping("{id}")
    public ResponseEntity<MenaDto> getMenaById(@PathVariable("id") Long menaId) {
        MenaDto menaDto = menaService.getMenaById(menaId);
        return ResponseEntity.ok(menaDto);
    }

    //Build Get All Mena Records API

    @GetMapping
    public ResponseEntity<List<MenaDto>> getAllMena(){

        List<MenaDto> allMena = menaService.getAllMena();
        return ResponseEntity.ok(allMena);

    }

    //Build Update Mena Record API

    @PutMapping("{id}")
public ResponseEntity<MenaDto> updateMena(@PathVariable("id") Long menaId, @RequestBody MenaDto updatedMena) {
    MenaDto menaDto = menaService.updateMena(menaId, updatedMena);
    return ResponseEntity.ok(menaDto);
}

//Build Delete Mena Record API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMena(@PathVariable("id") Long menaId){
        menaService.deleteMena(menaId);
        return ResponseEntity.ok("Minor has been deleted successfully!");
    }

}
