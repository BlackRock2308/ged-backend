package sn.demarch.ged.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.demarch.ged.models.User;
import sn.demarch.ged.repositories.UserRepository;
import sn.demarch.ged.services.UserService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    //************************ add user ****************************************

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        userService.saveUser(savedUser);
        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    //************************ get user by ID ****************************************

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> optionalUser = userService.getOneUser(id);
        if(!optionalUser.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalUser.get());
    }



    //************************ get All users ****************************************

    @GetMapping
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //************************ Delete user ****************************************


    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id){
        Optional<User> optionalUser= userService.getOneUser(id);
        if(!optionalUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userRepository.delete(optionalUser.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalUser.get());
    }
    //************************ Update user ****************************************


    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        User updateUser=userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

}
