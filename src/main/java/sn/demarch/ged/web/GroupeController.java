package sn.demarch.ged.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User;
import sn.demarch.ged.repositories.GroupeRepository;
import sn.demarch.ged.services.GroupeService;
import sn.demarch.ged.services.UserService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/groupes")
public class GroupeController {

    private final GroupeService groupeService;
    private final GroupeRepository groupeRepository;

    private final UserService userService;

    //************************ add groupe ****************************************

    @PostMapping
    public ResponseEntity<Groupe> saveGroupe(@RequestBody Groupe groupe){
        Groupe savedGroupe = groupeService.saveGroupe(groupe);
        groupeService.saveGroupe(savedGroupe);
        return ResponseEntity.status(HttpStatus.OK).body(savedGroupe);
    }

    //************************ get groupe by ID ****************************************

    @GetMapping("/{id}")
    public ResponseEntity<Groupe> getUserById(@PathVariable String id) {
        Optional<Groupe> optionalGroupe = groupeService.getOneGroupe(id);
        if(!optionalGroupe.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalGroupe.get());
    }



    //************************ get All groupes ****************************************

    @GetMapping
    public Iterable<Groupe> getAllGroupes(){
        return groupeService.getAllGroupes();
    }

    //************************ Delete groupe ****************************************


    @DeleteMapping("/{id}")
    public ResponseEntity<Groupe> deleteGroupe(@PathVariable String id){
        Optional<Groupe> optionalGroupe= groupeService.getOneGroupe(id);
        if(!optionalGroupe.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        groupeRepository.delete(optionalGroupe.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalGroupe.get());
    }
    //************************ assigne groupe ****************************************

    @PostMapping("/assign/{matricule}/{idGroupe}")
    public ResponseEntity assignGroupe(@PathVariable String matricule,
                             @PathVariable String idGroupe){
        Optional<Groupe> optionalGroupe= groupeService.getOneGroupe(idGroupe);
        Optional<User> optionalUser= userService.getOneUser(matricule);


        if(!optionalGroupe.isPresent()){
            System.out.println("This groupe is not present");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(!optionalUser.isPresent()){
            System.out.println("This User is not present");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        groupeService.assignUserGroupe(matricule, idGroupe);

        return ResponseEntity.status(HttpStatus.OK).body(optionalGroupe.get());

    }
    //************************ Update groupe ****************************************


    @PutMapping
    public ResponseEntity<Groupe> updateGroupe(@RequestBody Groupe groupe) {

        Groupe updateGroupe = groupeService.updateGroupe(groupe);
        return new ResponseEntity<>(updateGroupe, HttpStatus.OK);
    }
}
