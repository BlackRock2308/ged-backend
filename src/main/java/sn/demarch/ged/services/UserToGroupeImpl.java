package sn.demarch.ged.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.Groupe;
import sn.demarch.ged.models.UserToGroupe;
import sn.demarch.ged.repositories.GroupeRepository;
import sn.demarch.ged.repositories.UserRepository;
import sn.demarch.ged.repositories.UserToGroupeRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service("userToGroupeService")
@Transactional
public class UserToGroupeImpl implements UserToGroupeService{

    private UserToGroupeRepository userToGroupeRepository;
    private UserRepository userRepository;
    private GroupeRepository groupeRepository;

    @Override
    public Iterable<UserToGroupe> getAllUserToGroupe() {
        return userToGroupeRepository.findAll();
    }

    @Override
    public UserToGroupe saveUserToGroupe(UserToGroupe userToGroupe) {
        userToGroupe.setGroupe(groupeRepository.findById(userToGroupe.getGroupeId()).get());
        userToGroupe.setUser(userRepository.findById(userToGroupe.getUserMatricule()).get());

        return userToGroupeRepository.save(userToGroupe);
    }

    @Override
    public Optional<UserToGroupe> getOneUserToGroupe(String id) {
        return userToGroupeRepository.findById(id);
    }
    @Override
    public UserToGroupe updateUserTGroupe(UserToGroupe userToGroupe) {
        UserToGroupe existingUserToGroupe = userToGroupeRepository.findById(userToGroupe.getId()).orElse(null);
        existingUserToGroupe.setUser(userToGroupe.getUser());
        existingUserToGroupe.setGroupe(userToGroupe.getGroupe());
        return userToGroupeRepository.save(existingUserToGroupe);
    }
}
