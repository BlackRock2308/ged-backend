package sn.demarch.ged.web;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User_Groupe;
import sn.demarch.ged.repositories.UserToGroupeRepository;
import sn.demarch.ged.services.UserToGroupeService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/usersgroupes")
public class UserToGroupeController {

    private final UserToGroupeService userToGroupeService;
    private final UserToGroupeRepository userToGroupeRepository;


    //************************ add User to groupe ****************************************

    @PostMapping
    public ResponseEntity<User_Groupe> saveUserToGroupe(@RequestBody User_Groupe userToGroupe){
        User_Groupe savedUserGroupe = userToGroupeService.saveUserToGroupe(userToGroupe);
        userToGroupeService.saveUserToGroupe(savedUserGroupe);
        return ResponseEntity.status(HttpStatus.OK).body(savedUserGroupe);
    }

    //************************ get usertogroupe by ID ****************************************

    @GetMapping("/{id}")
    public ResponseEntity<User_Groupe> getUserById(@PathVariable String id) {
        Optional<User_Groupe> optionalUserGroupe = userToGroupeService.getOneUserToGroupe(id);
        if(!optionalUserGroupe.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalUserGroupe.get());
    }

    //************************ get All UsersTogroupes ****************************************

    @GetMapping
    public Iterable<User_Groupe> getAllUserToGroupe(){
        return userToGroupeService.getAllUserToGroupe();
    }

    //************************ Delete UsersTogroupes ****************************************


    @DeleteMapping("/{id}")
    public ResponseEntity<User_Groupe> deleteGroupe(@PathVariable String id){
        Optional<User_Groupe> optionalUserToGroupe = userToGroupeService.getOneUserToGroupe(id);
        if(!optionalUserToGroupe.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userToGroupeRepository.delete(optionalUserToGroupe.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalUserToGroupe.get());
    }
    //************************ Update UserToGroupe ****************************************


    @PutMapping
    public ResponseEntity<User_Groupe> updateUserToGroupe(@RequestBody User_Groupe userToGroupe) {

        User_Groupe updateUserToGroupe = userToGroupeService.updateUserTGroupe(userToGroupe);
        return new ResponseEntity<>(updateUserToGroupe, HttpStatus.OK);
    }

    @PostMapping("/security/role/assign/{matricule}/{idGroupe}")
    public String assignRole(@PathVariable String matricule,
                             @PathVariable String idGroupe){
        userToGroupeService.assignUserToGroupe(matricule, idGroupe);
        return "matricule" + matricule;
    }

    @PostMapping("/security/role/unassign/{matricule}/{idGroupe}")
    public String unAssignRole(@PathVariable String matricule,
                             @PathVariable String idGroupe){
        userToGroupeService.unAssignUsergroupe(matricule, idGroupe);
        return "matricule" + matricule;

    }



}
