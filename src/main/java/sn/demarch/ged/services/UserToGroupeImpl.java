package sn.demarch.ged.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.demarch.ged.models.User_Groupe;
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
    public Iterable<User_Groupe> getAllUserToGroupe() {
        return userToGroupeRepository.findAll();
    }

    @Override
    public User_Groupe saveUserToGroupe(User_Groupe user_groupe) {
        user_groupe.setGroupe(groupeRepository.findById(user_groupe.getIdGroupe()).get());
        user_groupe.setUser(userRepository.findById(user_groupe.getMatricule()).get());

        return userToGroupeRepository.save(user_groupe);
    }

    @Override
    public Optional<User_Groupe> getOneUserToGroupe(String id) {
        return userToGroupeRepository.findById(id);
    }
    @Override
    public User_Groupe updateUserTGroupe(User_Groupe user_groupe) {
        User_Groupe existingUserToGroupe = userToGroupeRepository.findById(user_groupe.getId()).orElse(null);
        existingUserToGroupe.setUser(user_groupe.getUser());
        existingUserToGroupe.setGroupe(user_groupe.getGroupe());
        return userToGroupeRepository.save(existingUserToGroupe);
    }
}
