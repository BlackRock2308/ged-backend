package sn.demarch.ged.web;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.demarch.ged.models.UserToGroupe;
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


    //************************ add groupe ****************************************

    @PostMapping
    public ResponseEntity<UserToGroupe> saveUserToGroupe(@RequestBody UserToGroupe userToGroupe){
        UserToGroupe savedUserGroupe = userToGroupeService.saveUserToGroupe(userToGroupe);
        userToGroupeService.saveUserToGroupe(savedUserGroupe);
        return ResponseEntity.status(HttpStatus.OK).body(savedUserGroupe);
    }

    //************************ get groupe by ID ****************************************

    @GetMapping("/{id}")
    public ResponseEntity<UserToGroupe> getUserById(@PathVariable String id) {
        Optional<UserToGroupe> optionalUserGroupe = userToGroupeService.getOneUserToGroupe(id);
        if(!optionalUserGroupe.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalUserGroupe.get());
    }

    //************************ get All UsersTogroupes ****************************************

    @GetMapping
    public Iterable<UserToGroupe> getAllUserToGroupe(){
        return userToGroupeService.getAllUserToGroupe();
    }

    //************************ Delete UsersTogroupes ****************************************


    @DeleteMapping("/{id}")
    public ResponseEntity<UserToGroupe> deleteGroupe(@PathVariable String id){
        Optional<UserToGroupe> optionalUserToGroupe = userToGroupeService.getOneUserToGroupe(id);
        if(!optionalUserToGroupe.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userToGroupeRepository.delete(optionalUserToGroupe.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalUserToGroupe.get());
    }
    //************************ Update UserToGroupe ****************************************


    @PutMapping
    public ResponseEntity<UserToGroupe> updateUserToGroupe(@RequestBody UserToGroupe userToGroupe) {

        UserToGroupe updateUserToGroupe = userToGroupeService.updateUserTGroupe(userToGroupe);
        return new ResponseEntity<>(updateUserToGroupe, HttpStatus.OK);
    }

}
