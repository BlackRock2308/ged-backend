package sn.demarch.ged.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.demarch.ged.models.Armoire;
import sn.demarch.ged.repositories.ArmoireRepository;
import sn.demarch.ged.services.ArmoireService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/armoires")
public class ArmoireController {

    private final ArmoireService armoireService;

    private final ArmoireRepository armoireRepository;


    //************************ add Armoire ****************************************

    @PostMapping
    public ResponseEntity<Armoire> saveArmoire(@RequestBody Armoire armoire){
        Armoire savedArmoire = armoireService.saveArmoire(armoire);
        armoireService.saveArmoire(savedArmoire);
        return ResponseEntity.status(HttpStatus.OK).body(savedArmoire);
    }

    //************************ get Armoire by ID ****************************************

    @GetMapping("/{id}")
    public ResponseEntity<Armoire> getArmoireById(@PathVariable String id) {
        Optional<Armoire> optionalArmoire = armoireService.getOneArmoire(id);
        if(!optionalArmoire.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalArmoire.get());
    }



    //************************ get All Armoires ****************************************

    @GetMapping
    public Iterable<Armoire> getAllArmoires(){
        return armoireService.getAllArmoires();
    }

    //************************ Delete Armoire ****************************************


    @DeleteMapping("/{id}")
    public ResponseEntity<Armoire> deleteArmoire(@PathVariable String id){
        Optional<Armoire> optionalArmoire= armoireService.getOneArmoire(id);
        if(!optionalArmoire.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        armoireRepository.delete(optionalArmoire.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalArmoire.get());
    }
    //************************ Update Armoire ****************************************


    @PutMapping
    public ResponseEntity<Armoire> updateArmoire(@RequestBody Armoire armoire) {

        Armoire updateArmoire= armoireService.updateArmoire(armoire);
        return new ResponseEntity<>(updateArmoire, HttpStatus.OK);
    }
}
