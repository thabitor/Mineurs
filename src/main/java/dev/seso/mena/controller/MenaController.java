package dev.seso.mena.controller;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.dto.MenaDto;
import dev.seso.mena.entity.Mena;
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
        return new ResponseEntity<>(savedMena, HttpStatus.CREATED);
    }

//    @PutMapping("{menaId}/guardian/{guardianId}")
//    public ResponseEntity<MenaDto> assignGuardianToMena (@PathVariable Long menaId, @PathVariable Long guardianId) {
//MenaDto savedMena = menaService.getMenaById(menaId);
//        GuardianDto guardianDto = guardianService.getGuardianById(guardianId);
//savedMena.assignGuardian(guardianDto);
//
//return ResponseEntity.ok("Guardian has been assigned successfully!");
//    }

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
