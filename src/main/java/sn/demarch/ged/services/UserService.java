package sn.demarch.ged.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.User;

import java.util.Optional;
import java.util.Set;

@Service("userService")
public interface UserService {

    public Iterable<User> getAllUsers();
    public User saveUser(User user);
    public Optional<User> getOneUser(String id);

    public Optional<User> getUserByPrenom(String prenom);

    public Optional<User> getUserByNom(String nom);

    public User updateUser(User user);

    public Set<Groupe> getUserGroupes(User user);
}
