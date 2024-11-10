package dev.seso.mena.controller;
import dev.seso.mena.dto.GuardianDto;
import dev.seso.mena.service.GuardianService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/guardian")
public class GuardianController {

    private GuardianService guardianService;

    //Build Add New Guardian Record API

    @PostMapping
    public ResponseEntity<GuardianDto> createGuardian(@RequestBody GuardianDto guardianDto) {
        GuardianDto savedGuardian = guardianService.createGuardian(guardianDto);
        return new ResponseEntity<>(savedGuardian, HttpStatus.CREATED);
    }

    //Build Get Guardian Record API

    @GetMapping("{id}")
    public ResponseEntity<GuardianDto> getGuardianById(@PathVariable("id") Long guardianId) {
        GuardianDto guardianDto = guardianService.getGuardianById(guardianId);
        return ResponseEntity.ok(guardianDto);
    }

    //Build Get All Guardian Records API

    @GetMapping
    public ResponseEntity<List<GuardianDto>> getAllGuardian(){

        List<GuardianDto> allGuardian = guardianService.getAllGuardian();
        return ResponseEntity.ok(allGuardian);

    }

    //Build Update Guardian Record API

    @PutMapping("{id}")
    public ResponseEntity<GuardianDto> updateGuardian(@PathVariable("id") Long guardianId, @RequestBody GuardianDto updatedGuardian) {
        GuardianDto guardianDto = guardianService.updateGuardian(guardianId, updatedGuardian);
        return ResponseEntity.ok(guardianDto);
    }

    //Build Delete Guardian Record API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGuardian(@PathVariable("id") Long guardianId){
        guardianService.deleteGuardian(guardianId);
        return ResponseEntity.ok("Guardian has been deleted successfully!");
    }

}
