package sn.demarch.ged.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.User;
import sn.demarch.ged.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getOneUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByPrenom(String prenom) {
        return userRepository.findByPrenom(prenom);
    }

    @Override
    public Optional<User> getUserByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getMatricule()).orElse(null);
        existingUser.setNom(user.getNom());
        existingUser.setPrenom(user.getPrenom());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }


}
